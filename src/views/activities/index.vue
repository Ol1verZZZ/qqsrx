<template>
  <div class="app-container">
    <div v-if="user">
      <el-row :gutter="20">

        <el-col :span="18" :xs="24">
          <el-card>
            <comment :comments="commentData" />
          </el-card>
        </el-col>

        <el-col :span="6" :xs="24">
          <user-card :user="user" />
        </el-col>

      </el-row>
    </div>
  </div>
</template>

<script>
import * as CommentData from '../../../mock/comments'
import comment from './components/comment'
import { mapGetters } from 'vuex'
import UserCard from './components/UserCard'

export default {
  name: 'Activities',
  components: { UserCard, comment },
  data() {
    return {
      user: {},
      activeTab: 'activity',
      commentData: []
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
    this.commentData = CommentData.comment.data
  },
  methods: {
    getUser() {
      this.user = {
        name: this.name,
        role: this.roles.join(' | '),
        email: 'admin@test.com',
        avatar: this.avatar
      }
    }
  }
}
</script>
