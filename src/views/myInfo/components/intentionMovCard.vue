<!--短评模块-->
<template>
  <div style="margin-bottom:20px;">
    <!-- 电影海报以及文字介绍栏 -->
    <el-row v-for="item in movies" :key="item.IMDb" style="margin-top: 2%">
      <!-- 电影海报介绍栏 -->
      <el-col :span="4"> <el-image
        style="width: 80%;  margin-right: 1%"
        :src="item.posterURL"
        :preview-src-list="[item.posterURL]"
      />
      </el-col>
      <!-- 电影文字介绍栏 -->
      <el-col :span="12">
        <div>
          <span class="movie-cname" style="display: inline-block">{{ item.chName }}</span>
          <span class="movie-cname" style="display: inline-block">/</span>
          <span class="movie-ename" style="display: inline-block">{{ item.enName }}</span>
          <!-- 评分 -->
          <el-rate
            v-model="value"
            disabled
            show-score
            text-color="#ff9900"
            :score-template="item.rate"
          />

          <div class="movie-info" style="margin-top: 2%;">类型：{{ item.mtype }}</div>
          <div class="movie-info">国家：{{ item.country }}</div>
          <div class="movie-info">日期：{{ item.date }}</div>
          <div class="movie-info">片长：{{ item.mlen }}分钟</div>
          <el-button size="mini" type="danger" @click="handleDelete(item.IMDb)">
            取消想看
          </el-button>
        </div>
      </el-col>

    </el-row>
    <!--    <JwChat-index-->
    <!--      :taleList="taleList"-->
    <!--      @enter="bindEnter"-->
    <!--      v-model="inputMsg"-->
    <!--      :toolConfig="tool"-->
    <!--    />-->
  </div>
</template>

<script>

import Vue from 'vue'
import { mapGetters } from 'vuex'

export default {
  components: {},
  props: {
    movies: {
      type: Array,
      required: true
    }
  },
  data() {
    return {
      inputComment: '',
      showItemId: '',
      taleList: [
        {
          date: '2020/04/25 21:19:07',
          text: { 'text': '起床不[加油]' },
          mine: false,
          name: '只盼流星不盼雨',
          img: 'image/two.jpeg'
        },
        {
          date: '2020/04/16 21:19:07',
          text: { 'text': '我不饿' },
          mine: true,
          name: '留恋人间不羡仙',
          img: 'image/three.jpeg'
        }
      ]
    }
  },
  computed: {
    ...mapGetters([
      'userID'
    ])
  },
  created() {
  },
  methods: {
    handleDelete(IMDb) {
      this.$notify({
        title: 'Success',
        message: 'Delete Successfully',
        type: 'success',
        duration: 2000
      })
      // 删除电影想看
    },
    /**
       * 点赞
       */
    likeClick(item) {
      if (item.isLike === null) {
        Vue.$set(item, 'isLike', true)
        item.likeNum++
      } else {
        if (item.isLike) {
          item.likeNum--
        } else {
          item.likeNum++
        }
        item.isLike = !item.isLike
      }
    }
  }
}
</script>

<style scoped lang="scss">

  @import "../../../../public/scss/index";

  .movie-cname {
    font-weight: bold;
    font-size: 24px;
  }

  .movie-ename {
    margin-top: 1%;
    margin-bottom: 1%;
    font-weight: bold;
    font-size: 24px;
    color: #777;
  }

  .movie-info {
    font-size: 20px;
    line-height: 1.8;
    color: #777;
    text-align: justify; //两边对齐
  }
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
