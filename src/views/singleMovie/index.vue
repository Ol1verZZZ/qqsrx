<template>
  <div class="app-container">
    <div v-if="movie">
      <el-row :gutter="20">

        <el-col :span="12" :xs="24">
          <movie-card :movie="movie" />
        </el-col>

        <el-col :span="12" :xs="24">
          <comment :comments="commentData" :i-m-db="movie.IMDb" />
        </el-col>

      </el-row>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import MovieCard from './components/MovieCard'
// import ShortComCard from './components/ShortComCard'
import { getMovie, getShortComment } from '@/api/movies'
// import * as CommentData from '../../../mock/comments'
import comment from './components/comment'

export default {
  name: 'SingleMov',
  components: { MovieCard, comment },
  data() {
    return {
      movie: {},
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
    this.getMovie()
    // this.testgetMovie()
    console.log('route:' + this.$route.fullPath)
    // 本地获取短评
    // this.commentData = CommentData.comment.data
    this.testgetShortComment()
  },
  methods: {
    async testgetShortComment() {
      // console.log('获取短评：IMDb=' + this.$route.params.IMDb)
      this.listLoading = true
      const { shortreviewlist } = await getShortComment(this.$route.query.IMDb)
      this.commentData = shortreviewlist
      this.listLoading = false
    },
    async testgetMovie() {
      this.listLoading = true
      const { movie } = await getMovie(this.$route.query.IMDb)
      this.movie = movie
      this.listLoading = false
    },
    getMovie() {
      this.movie = {
        posterURL: 'http://www.yylp.xyz/movie_pic/1.jpg',
        chName: '黑白魔女库伊拉',
        enName: 'Cruella',
        mtype: '喜剧犯罪',
        rate: '6.9',
        country: '美国',
        date: '2021-06-06',
        mlen: '134',
        IMDb: 'tt3228774',
        intro: '影片改编自道迪·史密斯的小说，故事设定在20世纪70年代朋克摇滚革命时期的伦敦，讲述了一个名叫艾丝黛拉（艾玛·斯通 饰）的年轻骗子的故事。艾丝黛拉是一个聪明又有创意的女孩，她决心用自己的设计让自己出名。' +
          '她和一对欣赏她的恶作剧嗜好的小偷交上了朋友，并能够一起在伦敦的街道上建立自己的生活。有一天，艾丝黛拉的时尚品味吸引了冯·赫尔曼男爵夫人（艾玛·汤普森 饰）的眼球，她是一位时尚界的传奇人物，拥有毁灭性的时尚和可' +
          '怕的高雅，但他们的关系引发了一系列事件，导致艾丝黛拉去拥抱她的邪恶一面，成为了兼具疯狂、时尚和报复心的库伊拉。',
        actor_list: [
          { IMDb: 'IMDb1', chName: '小明', enName: 'dirctor1', birthPlace: 'birthPlace1', birthDate: '1988-11-06', gender: '男', imgsrc: 'http://www.yylp.xyz/actor_pic/1.jpg' },
          { IMDb: 'IMDb2', chName: '小明', enName: 'actor2', birthPlace: 'birthPlace1', birthDate: '1988-11-06', gender: '男', imgsrc: 'http://www.yylp.xyz/actor_pic/2.jpg' },
          { IMDb: 'IMDb3', chName: '小明', enName: 'actor3', birthPlace: 'birthPlace1', birthDate: '1988-11-06', gender: '男', imgsrc: 'http://www.yylp.xyz/actor_pic/3.jpg' },
          { IMDb: 'IMDb4', chName: '小明', enName: 'actor4', birthPlace: 'birthPlace1', birthDate: '1988-11-06', gender: '男', imgsrc: 'http://www.yylp.xyz/actor_pic/4.jpg' },
          { IMDb: 'IMDb5', chName: '小明', enName: 'actor5', birthPlace: 'birthPlace1', birthDate: '1988-11-06', gender: '男', imgsrc: 'http://www.yylp.xyz/actor_pic/5.jpg' },
          { IMDb: 'IMDb6', chName: '小明', enName: 'actor6', birthPlace: 'birthPlace1', birthDate: '1988-11-06', gender: '男', imgsrc: 'http://www.yylp.xyz/actor_pic/6.jpg' }
        ],
        img_list: [
          'http://www.yylp.xyz/pic_in_movie/1.jpg',
          'http://www.yylp.xyz/pic_in_movie/2.jpg',
          'http://www.yylp.xyz/pic_in_movie/3.jpg',
          'http://www.yylp.xyz/pic_in_movie/4.jpg',
          'http://www.yylp.xyz/pic_in_movie/5.jpg',
          'http://www.yylp.xyz/pic_in_movie/6.jpg'
        ]

      }
    }
  }
}
</script>
