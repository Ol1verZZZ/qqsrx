<template>
  <div class="app-container">
    <div v-if="movie">
      <el-row :gutter="20">

        <el-col :span="12" :xs="24">
          <movie-card :movie="movie" />
        </el-col>

        <el-col :span="12" :xs="24">
          <short-com-card />
        </el-col>

      </el-row>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import MovieCard from './components/MovieCard'
import ShortComCard from './components/ShortComCard'
import { getMovie } from '@/api/movies'

export default {
  name: 'SingleMov',
  components: { MovieCard, ShortComCard },
  data() {
    return {
      movie: {},
      activeTab: 'activity'
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
  },
  methods: {
    async testgetMovie() {
      this.listLoading = true
      const { movie } = await getMovie(this.$route.params.IMDb)
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
        actor_list: [
          { IMDb: 'IMDb1', chName: '小明', enName: 'dirctor1', birthPlace: 'birthPlace1', birthDate: '1988-11-06', gender: '男', imgsrc: 'http://www.yylp.xyz/actor_pic/1.jpg' },
          { IMDb: 'IMDb2', chName: '小明', enName: 'actor2', birthPlace: 'birthPlace1', birthDate: '1988-11-06', gender: '男', imgsrc: 'http://www.yylp.xyz/actor_pic/2.jpg' },
          { IMDb: 'IMDb3', chName: '小明', enName: 'actor3', birthPlace: 'birthPlace1', birthDate: '1988-11-06', gender: '男', imgsrc: 'http://www.yylp.xyz/actor_pic/3.jpg' },
          { IMDb: 'IMDb4', chName: '小明', enName: 'actor4', birthPlace: 'birthPlace1', birthDate: '1988-11-06', gender: '男', imgsrc: 'http://www.yylp.xyz/actor_pic/4.jpg' },
          { IMDb: 'IMDb5', chName: '小明', enName: 'actor5', birthPlace: 'birthPlace1', birthDate: '1988-11-06', gender: '男', imgsrc: 'http://www.yylp.xyz/actor_pic/5.jpg' },
          { IMDb: 'IMDb6', chName: '小明', enName: 'actor6', birthPlace: 'birthPlace1', birthDate: '1988-11-06', gender: '男', imgsrc: 'http://www.yylp.xyz/actor_pic/6.jpg' }
        ]
      }
    }
  }
}
</script>
