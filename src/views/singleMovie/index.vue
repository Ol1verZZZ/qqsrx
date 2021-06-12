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

export default {
  name: 'SingleMovie',
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
  },
  methods: {
    getMovie() {
      this.movie = {
        chName: '黑白魔女库伊拉',
        enName: 'Cruella',
        mtype: '喜剧犯罪',
        rate: '6.9',
        country: '美国',
        date: '2021-06-06',
        mlen: '134',
        IMDb: 'tt3228774'
      }
    }
  }
}
</script>
