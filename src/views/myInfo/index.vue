<template>
  <div class="app-container">
    <div v-if="user">
      <el-row :gutter="20">

        <el-col :span="6" :xs="24">
          <user-card :user="user" />
        </el-col>

        <el-col :span="18" :xs="24">
          <el-card>
            <el-tabs v-model="activeTab">
              <el-tab-pane label="我的想看" name="activity">
                <intention-mov-card :movies="movies" />
              </el-tab-pane>
              <el-tab-pane label="我的看过" name="timeline">
                <watched-mov-card :movies="short_reviews" />
              </el-tab-pane>
              <el-tab-pane label="个人信息" name="account">
                <div slot="header" class="clearfix">
                  <span>编辑信息</span>
                </div>
                <account :user="user" />
              </el-tab-pane>
            </el-tabs>
          </el-card>
        </el-col>

      </el-row>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import UserCard from './components/UserCard'
import Account from './components/Account'
import intentionMovCard from './components/intentionMovCard'
import watchedMovCard from './components/watchedMovCard'
import { getIntentionList, getWatchedList } from '@/api/movies'
import { movies_mock } from '@/../mock/movies.js'
// import { getShortComment, getIntentionList } from "@/api/movies";

export default {
  name: 'MyInfo',
  components: { UserCard, Account, intentionMovCard, watchedMovCard },
  data() {
    return {
      user: {},
      activeTab: 'activity',
      movies: [],
      short_reviews: []
    }
  },
  computed: {
    ...mapGetters([
      'name',
      'avatar',
      'roles',
      'userID'
    ])
  },
  created() {
    this.getIntentionMovList()
    // this.getWatchedMovList()
    this.short_reviews = movies_mock.shortReviews
    this.getUser()
  },
  methods: {
    async getIntentionMovList() {
      this.listLoading = true
      const { intentions } = await getIntentionList(this.userID)
      this.movies = intentions
      this.listLoading = false
    },
    async getWatchedMovList() {
      this.listLoading = true
      const { shortReviews } = await getWatchedList(this.userID)
      this.short_reviews = shortReviews
      this.listLoading = false
    },
    getUser() {
      this.user = {
        name: this.name,
        role: this.roles.join(' | '),
        email: 'admin@test.com',
        avatar: this.avatar,
        gender: '男',
        rigDate: '2020-01-02'
      }
    }
  }
}
</script>
