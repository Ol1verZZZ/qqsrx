
<template>
  <el-card class="box-card-component" style="margin-left:8px;">
    <div slot="header" class="box-card-header">
      <img :src="movie.imgsrc">
    </div>

    <div style="position:relative;" @click="movieClick">
      <!--      <pan-thumb :image="avatar" class="panThumb" />-->
      <mallki class-name="mallki-text" :text="movie.chName" style="float: left;" />
      <div style="padding-top:5px;" class="progress-item" />
    </div>
  </el-card>
</template>

<script>
// import PanThumb from '@/components/PanThumb'
import Mallki from '@/components/TextHoverEffect/Mallki'

export default {
  components: { Mallki },
  filters: {
    statusFilter(status) {
      const statusMap = {
        success: 'success',
        pending: 'danger'
      }
      return statusMap[status]
    }
  },
  props: {
    movie: {
      image: '',
      chName: '',
      IMDb: ''
    }
  },
  data() {
    return {
      statisticsData: {
        article_count: 1024,
        pageviews_count: 1024
      }
    }
  },
  methods: {
    movieClick() { // 跳转到对应的电影介绍页面
      console.log(this.movie.IMDb)
      this.$router.push({
        name: 'testm',
        query: {
          IMDb: this.movie.IMDb
        }
      })
    }
  }
}
</script>

<style lang="scss" >
.box-card-component{
  .el-card__header {
    padding: 0px!important;
  }
}
</style>
<style lang="scss" scoped>
.box-card-component {
  width: 110%;
  .box-card-header {
    position: relative;

    /*height: 220px;*/
    img {
      width: 99%;
      /*height: 100%;*/
      transition: all 0.2s linear;
      &:hover {
        transform: scale(1.1, 1.1);
        filter: contrast(130%);
      }
    }
  }
  .mallki-text {
    /*position: center;*/
    font-size: 18px;
    font-weight: bold;
  }
  .panThumb {
    z-index: 100;
    height: 70px!important;
    width: 70px!important;
    position: absolute!important;
    top: -45px;
    left: 0px;
    border: 5px solid #ffffff;
    background-color: #fff;
    margin: auto;
    box-shadow: none!important;
    ::v-deep .pan-info {
      box-shadow: none!important;
    }
  }
  .progress-item {
    margin-bottom: 10px;
    font-size: 14px;
  }

}
</style>
