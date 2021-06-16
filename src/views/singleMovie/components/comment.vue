<!--短评模块-->
<template>
  <el-card style="margin-bottom:20px;">
    <div class="container">
      <div v-for="item in comments" :key="item.userId" class="comment">
        <!--头像、昵称、时间-->
        <div class="info">
          <img class="avatar" :src="item.imgsrc" width="36" height="36">
          <div class="right">
            <div class="name">{{ item.username }}
              <!--点赞-->
              <span class="like" :class="{active: item.isLike}" @click="likeClick(item)">
                <i class="iconfont icon-like" />
                <span class="like-num">{{ item.srLikeSum > 0 ? item.srLikeSum + '人赞' : '赞' }}</span>
              </span>
            </div>
            <div class="date">{{ item.postTime }}</div>
          </div>
        </div>
        <!--短评内容-->
        <div class="content">{{ item.srContent }}</div>

      </div>
    </div>
  </el-card>
</template>

<script>

import Vue from 'vue'
import { addLikeShortComment, checkLike } from '@/api/movies'
import { mapGetters } from 'vuex'

export default {
  components: {},
  props: {
    comments: {
      type: Array,
      required: true
    },
    IMDb: String
  },
  data() {
    return {
      inputComment: '',
      showItemId: ''
    }
  },
  computed: {
    ...mapGetters([
      'userID'
    ])
  },
  created() {
    console.log(this.comments)
    for (const i in this.comments) {
      i.isLike = this.checklike(i.userId)
    }
  },
  methods: {
    async checklike(userId) {
      this.listLoading = true
      const { hasLiked } = await checkLike(userId, this.movie.IMDb, this.userID)
      this.listLoading = false
      return hasLiked
    },
    likeClick(item) {
      if (item.isLike === null) {
        Vue.$set(item, 'isLike', true)
        item.srLikeSum++
      } else {
        if (item.isLike) {
          item.srLikeSum--
        } else {
          item.srLikeSum++
          addLikeShortComment(item.userId, this.IMDb, this.userID)
          console.log('点赞：' + item.userId + this.IMDb + this.userID)
        }
        item.isLike = !item.isLike
      }
    }
  }
}
</script>

<style scoped lang="scss">

  @import "../../../../public/scss/index";

  .container {
    padding: 0 10px;
    box-sizing: border-box;
    .comment {
      display: flex;
      flex-direction: column;
      padding: 10px;
      border-bottom: 1px solid $border-fourth;
      .info {
        display: flex;
        align-items: center;
        .avatar {
          border-radius: 50%;
        }
        .right {
          display: flex;
          flex-direction: column;
          width: 100%;
          margin-left: 10px;
          .name {
            font-size: 16px;
            color: $text-main;
            margin-bottom: 5px;
            font-weight: 500;
          }
          .date {
            font-size: 12px;
            color: $text-minor;
          }
        }
      }
      .content {
        font-size: 16px;
        color: $text-main;
        line-height: 20px;
        padding: 10px 0;
      }
      .like {
        font-size: 15px;
        float: right;
        cursor: pointer;
        &.active, &:hover {
          color: $color-main;
        }
        .iconfont {
          font-size: 14px;
          margin-right: 5px;
        }

      }
    }
  }
</style>
