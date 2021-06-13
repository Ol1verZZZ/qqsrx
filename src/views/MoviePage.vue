/* eslint-disable */
<template>
  <div>
    <!--  ceshiyixia-->
    <base-header class="pb-6 pb-8 pt-5 pt-md-8 bg-gradient-success">
      <!-- Movie Cards -->
      <b-row>
        <b-col xl="2" md="6">
          <movie-card
            title="Total traffic"
            image="http://www.yylp.xyz/movie_pic/1.jpg"
            class="mb-4"
          />
        </b-col>
        <b-col xl="2" md="6">
          <movie-card
            title="Total traffic"
            image="http://www.yylp.xyz/movie_pic/2.jpg"
            class="mb-4"
          />
        </b-col>
        <b-col xl="2" md="6">
          <movie-card
            title="Total traffic"
            image="http://www.yylp.xyz/movie_pic/3.jpg"
            class="mb-4"
          />

        </b-col>
        <b-col xl="2" md="6">
          <movie-card
            title="Total traffic"
            image="http://www.yylp.xyz/movie_pic/4.jpg"
            class="mb-4"
          />
        </b-col>
        <b-col xl="2" md="6">
          <movie-card
            title="Total traffic"
            image="http://www.yylp.xyz/movie_pic/5.jpg"
            class="mb-4"
          />
        </b-col>
        <b-col xl="2" md="6">
          <movie-card
            title="Total traffic"
            image="http://www.yylp.xyz/movie_pic/6.jpg"
            class="mb-4"
          />
        </b-col>
      </b-row>
    </base-header>

    <!--Charts-->
    <b-container fluid class="mt--7">
      <b-row>
        <b-col xl="8" class="mb-5 mb-xl-0">
          <card type="default" header-classes="bg-transparent">
            <b-row slot="header" align-v="center">
              <b-col>
                <h6 class="text-light text-uppercase ls-1 mb-1">Overview</h6>
                <h5 class="h3 text-white mb-0">Sales value</h5>
              </b-col>
              <b-col>
                <b-nav class="nav-pills justify-content-end">
                  <b-nav-item
                    class="mr-2 mr-md-0"
                    :active="bigLineChart.activeIndex === 0"
                    link-classes="py-2 px-3"
                    @click.prevent="initBigChart(0)"
                  >
                    <span class="d-none d-md-block">Month</span>
                    <span class="d-md-none">M</span>
                  </b-nav-item>
                  <b-nav-item
                    link-classes="py-2 px-3"
                    :active="bigLineChart.activeIndex === 1"
                    @click.prevent="initBigChart(1)"
                  >
                    <span class="d-none d-md-block">Week</span>
                    <span class="d-md-none">W</span>
                  </b-nav-item>
                </b-nav>
              </b-col>
            </b-row>
            <line-chart
              ref="bigChart"
              :height="350"
              :chart-data="bigLineChart.chartData"
              :extra-options="bigLineChart.extraOptions"
            />
          </card>
        </b-col>

        <b-col xl="4" class="mb-5 mb-xl-0">
          <card header-classes="bg-transparent">
            <b-row slot="header" align-v="center">
              <b-col>
                <h6 class="text-uppercase text-muted ls-1 mb-1">Performance</h6>
                <h5 class="h3 mb-0">Total orders</h5>
              </b-col>
            </b-row>

            <bar-chart
              ref="barChart"
              :height="350"
              :chart-data="redBarChart.chartData"
            />
          </card>
        </b-col>
      </b-row>
      <!-- End charts-->

      <!--Tables-->
      <b-row class="mt-5">
        <b-col xl="8" class="mb-5 mb-xl-0">
          <page-visits-table />
        </b-col>
        <b-col xl="4" class="mb-5 mb-xl-0">
          <social-traffic-table />
        </b-col>
      </b-row>
      <!--End tables-->
    </b-container>

  </div>
</template>

<script>
// Charts
// import * as chartConfigs from '@/components/Charts/config'
import LineChart from '@/components/Charts/LineChart'
// import BarChart from '@/components/Charts/BarChart'

// Components
// import BaseProgress from '@/components/BaseProgress'
// import StatsCard from '@/components/Cards/StatsCard'
import MovieCard from '@/components/Cards/MovieCard'

// Tables
import SocialTrafficTable from './Dashboard/SocialTrafficTable'
import PageVisitsTable from './Dashboard/PageVisitsTable'

export default {
  components: {
    LineChart,
    // BarChart,
    MovieCard,
    PageVisitsTable,
    SocialTrafficTable
  },
  data() {
    return {
      hotmovlist: {}
    }
  },
  mounted() {
    this.initBigChart(0)
  },
  methods: {
    getHotMovList() {
      this.hotmovlist = [
        { imgsrc: 'http://www.yylp.xyz/movie_pic/1.jpg', chName: '黑白魔女库伊拉' },
        { imgsrc: 'http://www.yylp.xyz/movie_pic/2.jpg', chName: '黑白魔女库伊拉' },
        { imgsrc: 'http://www.yylp.xyz/movie_pic/3.jpg', chName: '黑白魔女库伊拉' },
        { imgsrc: 'http://www.yylp.xyz/movie_pic/4.jpg', chName: '黑白魔女库伊拉' },
        { imgsrc: 'http://www.yylp.xyz/movie_pic/5.jpg', chName: '黑白魔女库伊拉' }
      ]
    }
  }
}
</script>

<style>
  .el-table .cell{
    padding-left: 0px;
    padding-right: 0px;
  }
</style>
