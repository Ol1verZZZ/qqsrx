/* eslint-disable */
<template>
  <div class="app-container">
    <el-row :gutter="20">

      <el-col :span="16" :xs="24" style="margin-left: 2%">
        <el-card style="margin-bottom: 2%;">
          <div class="title_header"><span style="margin-left: 2%">正在热映</span></div>
          <el-col v-for="item in hotmovlist" :key="item.imgsrc" :xs="{span: 24}" :sm="{span: 12}" :md="{span: 12}" :lg="{span: 6}" :xl="{span: 4}" style="margin-bottom:30px;margin-right:3%;">
            <box-card :movie="item" />
          </el-col>
        </el-card>

        <el-card>
          <el-tabs v-model="default_tab" @tab-click="handleClick">
            <el-tab-pane label="最新电影" name="first">
              <el-col v-for="item in hotmovlist" :key="item.imgsrc" :xs="{span: 24}" :sm="{span: 12}" :md="{span: 12}" :lg="{span: 6}" :xl="{span: 4}" style="margin-bottom:30px;margin-right:3%;;">
                <box-card :movie="item" />
              </el-col>
            </el-tab-pane>
            <el-tab-pane label="高分电影" name="second">
              <el-col v-for="item in goodmovlist" :key="item.imgsrc" :xs="{span: 24}" :sm="{span: 12}" :md="{span: 12}" :lg="{span: 6}" :xl="{span: 4}" style="margin-bottom:30px;margin-right:3%;;">
                <box-card :movie="item" />
              </el-col>
            </el-tab-pane>
            <el-tab-pane label="冷门佳片" name="third">
              <el-col v-for="item in hotmovlist" :key="item.imgsrc" :xs="{span: 24}" :sm="{span: 12}" :md="{span: 12}" :lg="{span: 6}" :xl="{span: 4}" style="margin-bottom:30px;margin-right:3%;;">
                <box-card :movie="item" />
              </el-col>
            </el-tab-pane>
            <el-tab-pane label="国产好片" name="fourth">
              <el-col v-for="item in chinesemovlist" :key="item.imgsrc" :xs="{span: 24}" :sm="{span: 12}" :md="{span: 12}" :lg="{span: 6}" :xl="{span: 4}" style="margin-bottom:30px;margin-right:3%;;">
                <box-card :movie="item" />
              </el-col>
            </el-tab-pane>
          </el-tabs>
        </el-card>
      </el-col>

      <el-col :span="6" :xs="24" />
    </el-row>

  </div>
</template>

<script>
import BoxCard from './components/BoxCard'
import { getHotMovList } from '@/api/movies'
import { hot_movie_list_mock, good_movie_list_mock, chinese_movie_list_mock } from '@/../mock/movies'

export default {
  name: 'MoviesBoard',
  components: {
    BoxCard
  },
  data() {
    return {
      hotmovlist: [],
      newmovlist: [],
      goodmovlist: [],
      coldmovlist: [],
      chinesemovlist: [],
      default_tab: 'first'
    }
  },
  created() {
    // this.getHotMovList()
    this.hotmovlist = hot_movie_list_mock
    this.goodmovlist = good_movie_list_mock
    this.chinesemovlist = chinese_movie_list_mock
  },
  methods: {
    async getHotMovList() {
      this.listLoading = true
      const { hotmovlist } = await getHotMovList()
      this.hotmovlist = hotmovlist
      this.listLoading = false
      console.log(hotmovlist)
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

.title_header {
  border-bottom: 1px solid #dfe6ec;
  padding-bottom: 10px;
  margin-bottom: 10px;
  font-weight: bold;
}
</style>
