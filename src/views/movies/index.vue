/* eslint-disable */
<template>
  <div class="dashboard-editor-container">

    <el-row :gutter="8">
      <el-col v-for="item in hotmovlist" :key="item.imgsrc" :xs="{span: 24}" :sm="{span: 12}" :md="{span: 12}" :lg="{span: 6}" :xl="{span: 3}" style="margin-bottom:30px;margin-right:30px;">
        <box-card :movie="item" />
      </el-col>
    </el-row>
  </div>
</template>

<script>
import BoxCard from './components/BoxCard'
import { getHotMovList } from '@/api/movies'

export default {
  name: 'MoviesBoard',
  components: {
    BoxCard
  },
  data() {
    return {
      hotmovlist: {}
    }
  },
  created() {
    // this.getHotMovList()
    this.getLocalHotMovList()
  },
  methods: {
    async getHotMovList() {
      this.listLoading = true
      const { hotmovlist } = await getHotMovList()
      this.hotmovlist = hotmovlist
      this.listLoading = false
      console.log(hotmovlist)
    },
    getLocalHotMovList() {
      this.hotmovlist = [
        {
          'imgsrc': 'http://www.yylp.xyz/movie_pic/1.jpg',
          'chName': '黑白魔女库伊拉',
          'IMDb': 'tt3228774'
        },
        {
          'imgsrc': 'http://www.yylp.xyz/movie_pic/2.jpg',
          'chName': '智取威虎山',
          'IMDb': 'tt3228774'
        }
      ]
    }
  }
}
</script>

<style lang="scss" scoped>
.dashboard-editor-container {
  padding: 32px;
  background-color: rgb(240, 242, 245);
  position: relative;

  .github-corner {
    position: absolute;
    top: 0px;
    border: 0;
    right: 0;
  }

  .chart-wrapper {
    background: #fff;
    padding: 16px 16px 0;
    margin-bottom: 32px;
  }
}

@media (max-width:1024px) {
  .chart-wrapper {
    padding: 8px;
  }
}
</style>
