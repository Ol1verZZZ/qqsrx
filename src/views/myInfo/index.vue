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
                <watched-mov-card :movies="movies" />
              </el-tab-pane>
              <el-tab-pane label="个人信息" name="account">
                <div slot="header" class="clearfix">
                  <span>编辑信息</span>
                </div>
                <account :user="user" />
              </el-tab-pane>
            </el-tabs>

            <!--            <record-card :movies="movies" />-->

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

export default {
  name: 'MyInfo',
  components: { UserCard, Account, intentionMovCard, watchedMovCard },
  data() {
    return {
      user: {},
      activeTab: 'activity',
      movies: []
    }
  },
  computed: {
    ...mapGetters([
      'name',
      'avatar',
      'roles'
    ])
  },
  created() {
    this.getUser()
  },
  methods: {
    getUser() {
      this.user = {
        name: this.name,
        role: this.roles.join(' | '),
        email: 'admin@test.com',
        avatar: this.avatar,
        gender: '男',
        rigDate: '2020-01-02'
      }
      this.movies = [
        {
          posterURL: 'http://www.yylp.xyz/movie_pic/1.jpg',
          chName: '黑白魔女库伊拉',
          enName: 'Cruella',
          mtype: '喜剧犯罪',
          rate: '6.9',
          country: '美国',
          date: '2021-06-06',
          mlen: '134',
          IMDb: 'tt3228774'
        },
        {
          posterURL: 'http://www.yylp.xyz/movie_pic/1.jpg',
          chName: '黑白魔女库伊拉',
          enName: 'Cruella',
          mtype: '喜剧犯罪',
          rate: '6.9',
          country: '美国',
          date: '2021-06-06',
          mlen: '134',
          IMDb: 'tt3228773'
        }

      ]
    }
  }
}
</script>
