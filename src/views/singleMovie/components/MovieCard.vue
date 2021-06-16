/* eslint-disable */

<template>
  <el-card style="margin-bottom:20px;">
    <p>用户ID：{{ this.userID }}</p>
    <!-- 电影海报以及文字介绍栏 -->
    <el-row style="margin-top: 2%">
      <!-- 电影海报介绍栏 -->
      <el-col :span="12"> <el-image
        style="width: 200px; height: 300px; float: right; margin-right: 10%"
        :src="movie.posterURL"
        :preview-src-list="srcList"
      />
      </el-col>
      <!-- 电影文字介绍栏 -->
      <el-col :span="12">
        <div>
          <div class="movie-cname">{{ movie.chName }}</div>
          <div class="movie-ename">{{ movie.enName }}</div>
          <!-- 评分 -->
          <el-rate
            v-model="value"
            disabled
            show-score
            text-color="#ff9900"
            :score-template="movie.rate"
          />

          <div class="movie-info" style="margin-top: 2%">类型：{{ movie.mtype }}</div>
          <div class="movie-info">国家：{{ movie.country }}</div>
          <div class="movie-info">日期：{{ movie.date }}</div>
          <div class="movie-info">片长：{{ movie.mlen }}</div>
          <div class="movie-info">IMDb：{{ movie.IMDb }}</div>

        </div>
        <el-button v-if="movie.intention" size="mini" type="warning" @click="intentionClick">
          想看
        </el-button>
        <el-button v-if="!movie.intention" size="mini" type="info" @click="intentionClick">
          想看
        </el-button>

        <el-button v-if="movie.watched" size="mini" type="warning" @click="watchedClick">
          看过
        </el-button>
        <el-button v-if="!movie.watched" size="mini" type="info" @click="watchedClick">
          看过
        </el-button>
      </el-col>
    </el-row>

    <div class="user-bio">
      <!-- 剧情简介 -->
      <div class="user-education user-bio-section" style="margin-right: 6%; margin-left: 6%">
        <div class="user-bio-section-header"><svg-icon icon-class="education" /><span>剧情简介</span></div>
        <div class="movie-intro">
          影片改编自道迪·史密斯的小说，故事设定在20世纪70年代朋克摇滚革命时期的伦敦，讲述了一个名叫艾丝黛拉（艾玛·斯通 饰）的年轻骗子的故事。艾丝黛拉是一个聪明又有创意的女孩，她决心用自己的设计让自己出名。她和一对欣赏她的恶作剧嗜好的小偷交上了朋友，并能够一起在伦敦的街道上建立自己的生活。有一天，艾丝黛拉的时尚品味吸引了冯·赫尔曼男爵夫人（艾玛·汤普森 饰）的眼球，她是一位时尚界的传奇人物，拥有毁灭性的时尚和可怕的高雅，但他们的关系引发了一系列事件，导致艾丝黛拉去拥抱她的邪恶一面，成为了兼具疯狂、时尚和报复心的库伊拉。
        </div>
      </div>

      <!-- 演职人员表 -->
      <div class="user-education user-bio-section" style="margin-right: 6%; margin-left: 6%">
        <div class="user-bio-section-header"><svg-icon icon-class="education" /><span>演职人员表</span></div>
        <div class="box-center">
          <el-row :gutter="24">
            <el-col v-for="actor_item in movie.actor_list" :key="actor_item.name" :span="4" style="height: 40%;" @click.native="actorClick(actor_item)">
              <el-image
                style="width: 100%; height: 100%;"
                :src="actor_item.imgsrc"
              />
              <p class="text-center">{{ actor_item.chName }}</p>
            </el-col>

          </el-row>
        </div>
      </div>

      <!-- 相关图片 -->
      <div class="user-education user-bio-section" style="margin-right: 6%; margin-left: 6%">
        <div class="user-bio-section-header"><svg-icon icon-class="education" /><span>相关图片</span></div>
        <el-carousel :interval="4000" type="card" height="220px">
          <el-carousel-item v-for="image in movie.img_list" :key="image">
            <el-image :src="image" style="height: 100%" />
          </el-carousel-item>
        </el-carousel>
      </div>

      <el-image-viewer
        v-if="showViewer"
        :on-close="closeViewer"
        :url-list="movie.img_list"
      />

      <el-button type="primary" @click="onPreview">查看图片</el-button>

      <el-dialog title="演员信息" :visible.sync="dialogFormVisible">
        <el-row>
          <!-- 演员介绍栏 -->
          <el-col :span="12"> <el-image
            style="width: 200px; height: 280px; float: right; margin-right: 10%"
            :src="display_actor_info.imgsrc"
            :preview-src-list="[display_actor_info.imgsrc]"
          />
          </el-col>
          <!-- 演员文字介绍栏 -->
          <el-col :span="12">
            <div class="movie-cname">{{ display_actor_info.chName }}</div>
            <div class="movie-ename">{{ display_actor_info.enName }}</div>
            <!-- 性别 -->
            <div class="movie-info" style="margin-top: 2%">性别：{{ display_actor_info.gender }}</div>
            <!-- 出生地  -->
            <div class="movie-info">出生地：{{ display_actor_info.birthPlace }}</div>
            <!-- 出生日期 -->
            <div class="movie-info">出生日期：{{ display_actor_info.birthDate }}</div>
            <!-- IMDb -->
            <div class="movie-info" style="margin-bottom: 20px">IMDb：{{ display_actor_info.IMDb }}</div>
          </el-col>
        </el-row>
        <div style="margin-left: 5%; margin-right: 5%; margin-top: 2%">
          <div class="user-bio-section-header" style="margin-bottom: 20px"><svg-icon icon-class="education" /><span>人员简介</span></div>
          <div class="movie-intro" style="height: 150px; overflow-y:scroll">
            影片改编自道迪·史密斯的小说，故事设定在20世纪70年代朋克摇滚革命时期的伦敦，讲述了一个名叫艾丝黛拉（艾玛·斯通 饰）的年轻骗子的故事。艾丝黛拉是一个聪明又有创意的女孩，她决心用自己的设计让自己出名。她和一对欣赏她的恶作剧嗜好的小偷交上了朋友，并能够一起在伦敦的街道上建立自己的生活。有一天，艾丝黛拉的时尚品味吸引了冯·赫尔曼男爵夫人（艾玛·汤普森 饰）的眼球，她是一位时尚界的传奇人物，拥有毁灭性的时尚和可怕的高雅，但他们的关系引发了一系列事件，导致艾丝黛拉去拥抱她的邪恶一面，成为了兼具疯狂、时尚和报复心的库伊拉。
          </div>
        </div>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">
            Cancel
          </el-button>
          <el-button type="primary" @click="dialogFormVisible = false">
            Confirm
          </el-button>
        </div>
      </el-dialog>

      <el-dialog
        title="标记看过"
        :visible.sync="dialogVisible"
        width="30%"
      >
        <span class="username text-muted" style="display: inline-block;">给出你的评价：</span>
        <span class="username text-muted" style="display: inline-block;">
          <!-- 评分 -->
          <el-rate
            v-model="my_value"
            :colors="colors"
            show-text
          />
        </span>
        <span class="username text-muted" style="display: block;margin-top: 5%">简短评论：</span>
        <el-input
          v-model="my_comment"
          type="textarea"
          placeholder="请输入评价"
          maxlength="50"
          show-word-limit
        />
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="push_m_comment">确 定</el-button>
        </span>
      </el-dialog>

    </div>

  </el-card>

</template>

<script>
import { addIntention, deleteIntention } from '@/api/movies'
import { mapGetters } from 'vuex'
import ElImageViewer from 'element-ui/packages/image/src/image-viewer'
import { addWatched } from '@/api/movies'
// import * as CommentData from "../../../../mock/comments"

export default {
  components: {
    ElImageViewer
  },
  props: {
    movie: {
      type: Object,
      default: () => {
        return {
          posterURL: '',
          chName: '',
          enName: '',
          mtype: '',
          rate: '',
          country: '',
          date: '',
          mlen: '',
          IMDb: '',
          intention: false,
          watched: false,
          actor_list: [],
          img_list: []
        }
      }
    }
  },
  data() {
    return {
      showViewer: false,
      my_comment: '',
      my_value: null,
      colors: ['#99A9BF', '#F7BA2A', '#FF9900'],
      dialogVisible: false,
      dialogFormVisible: false,
      srcList: [
        'http://www.yylp.xyz/movie_pic/1.jpg',
        'http://www.yylp.xyz/movie_pic/2.jpg'
      ],
      value: 3.7,
      fits: ['fill', 'contain', 'cover', 'none', 'scale-down'],
      actor_url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',

      display_actor_info: {
        IMDb: '',
        chName: '',
        enName: '',
        birthPlace: '',
        birthDate: '',
        gender: '',
        imgsrc: ''
      }
    }
  },
  methods: {
    async push_m_comment() { // 标记看过时提交短评
      console.log('用户ID：' + this.userID)
      console.log('提交评论：' + this.my_comment + '评分：' + this.my_value)
      this.listLoading = true
      const { code } = await addWatched(this.userID, this.movie.IMDb, this.my_value, this.my_comment)
      console.log(code)
      this.listLoading = false
      this.dialogVisible = false
    },
    onPreview() {
      console.log('打开图片浏览器')
      this.showViewer = true
    },
    closeViewer() {
      this.showViewer = false
    },
    actorClick(actoritem) {
      this.dialogFormVisible = true
      this.display_actor_info = actoritem
      console.log('点击了演员' + actoritem.chName)
    },
    intentionClick() {
      const intn = this.movie.intention
      if (intn) { // 已经标记过 点击是要删除想看
        console.log('删除想看，userID=' + this.userID)
        deleteIntention(this.userID, this.movie.IMDb)
      } else { // 没有标记过 点击是要标记想看
        console.log('标记想看，userID=' + this.userID)
        addIntention(this.userID, this.movie.IMDb)
      }
      this.movie.intention = !intn
      console.log('intention:' + this.movie.intention)
      this.$forceUpdate()
    },
    watchedClick() {
      console.log('测试一下时间' + this.getTime())
      const intn = this.movie.watched
      if (intn) { // 已经标记过 点击无效
      } else { // 没有标记过 点击是要标记看过
        // 弹出写短评的对话框
        this.dialogVisible = true
        console.log('标记看过，userID=' + this.userID)
        this.movie.watched = true
      }
      this.$forceUpdate()
    },
    getTime() {
      const date = new Date()
      const year = date.getFullYear() // 年
      const month = date.getMonth() + 1 // 月
      const day = date.getDate() // 日
      const week = date.getDay() // 星期
      const weekArr = ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六']
      let hour = date.getHours() // 时
      hour = hour < 10 ? '0' + hour : hour // 如果只有一位，则前面补零
      let minute = date.getMinutes() // 分
      minute = minute < 10 ? '0' + minute : minute // 如果只有一位，则前面补零
      let second = date.getSeconds() // 秒
      second = second < 10 ? '0' + second : second // 如果只有一位，则前面补零
      return `${year}-${month}-${day} ${hour}:${minute}:${second} ${weekArr[week]}`
    }
  },
  computed: {
    ...mapGetters([
      'name',
      'userID'
    ])
  }
}
</script>

<style lang='scss' scoped>
.el-row {
  margin-bottom: 20px;
  &:last-child {
    margin-bottom: 0;
  }
}
.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #99a9bf;
}
.bg-purple {
  background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
.box-center {
  margin: 0 auto;
  display: table;
}

.text-muted {
  color: #777;
}

.movie-cname {
  font-weight: bold;
  font-size: 30px;
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

.movie-intro {
  font-size: 18px;
  line-height: 2;
  color: #777;
  text-align: justify; //两边对齐
}

.user-profile {
  .user-name {
    font-weight: bold;
  }

  .box-center {
    padding-top: 10px;
  }

  .user-role {
    padding-top: 10px;
    font-weight: 400;
    font-size: 14px;
  }

  .box-social {
    padding-top: 30px;

    .el-table {
      border-top: 1px solid #dfe6ec;
    }
  }

  .user-follow {
    padding-top: 20px;
  }
}

.user-bio {
  margin-top: 20px;
  color: #606266;

  span {
    padding-left: 4px;
  }

  .user-bio-section {
    font-size: 14px;
    padding: 15px 0;

    .user-bio-section-header {
      border-bottom: 1px solid #dfe6ec;
      padding-bottom: 10px;
      margin-bottom: 10px;
      font-weight: bold;
    }
  }
}
</style>
