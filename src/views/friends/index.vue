<template>
  <div class="app-container">
    <el-table v-loading="listLoading" :data="list" border fit highlight-current-row style="width: 100%">
      <el-table-column align="center" label="用户ID" width="80">
        <template slot-scope="{row}">
          <span>{{ row.userID }}</span>
        </template>
      </el-table-column>

      <el-table-column width="80px" align="center" label="用户头像">
        <template slot-scope="{row}">
          <el-avatar>
            <el-image
              style="height: 100%; width: 100%"
              :src="row.avatar"
              :preview-src-list="[row.avatar]"
            />
          </el-avatar>

        </template>
      </el-table-column>

      <el-table-column width="120px" align="center" label="用户名称">
        <template slot-scope="{row}">
          <span>{{ row.name }}</span>
        </template>
      </el-table-column>

      <el-table-column min-width="300px" label="用户简介">
        <template slot-scope="{row}">
          <span>{{ row.info }}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="操作" width="120">
        <template slot-scope="{row}">
          <el-button
            type="primary"
            size="small"
            icon="el-icon-edit"
            @click="chatClick(row)"
          >
            发起会话
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-button type="text" @click="centerDialogVisible = true">点击打开 Dialog</el-button>

    <el-dialog
      title="对话框"
      :visible.sync="centerDialogVisible"
      width="30%"
      center
    >
      <span>
        <JwChat
          v-model="inputMsg"
          :tale-list="taleList"
          style="width: 100%"
          @enter="bindEnter"
        />
      </span>

    </el-dialog>

  </div>

</template>

<script>
import { fetchList } from '@/api/article'
import { friends } from '@/../mock/friends'

export default {
  name: 'FriendTable',
  data() {
    return {
      centerDialogVisible: false,
      list: null,
      listLoading: true,
      taleList: [
        {
          date: '2020-04-25 21:19:07',
          text: { 'text': '起床不[加油]' },
          mine: false,
          name: '只盼流星不盼雨',
          img: 'http://ww4.sinaimg.cn/bmiddle/006DLFVFgy1ft0j2pddjuj30v90uvagf.jpg'
        },
        {
          date: '2020-04-16 21:19:07',
          text: { 'text': '我不饿' },
          mine: true,
          name: '留恋人间不羡仙',
          img: 'https://wx4.sinaimg.cn/mw690/69e273f8gy1ft1541dmb7j215o0qv7wh.jpg'
        }
      ],
      inputMsg: ''
    }
  },
  created() {
    // this.getList()
    this.list = friends.data
    this.listLoading = false
  },
  methods: {
    chatClick(row) {

    },
    bindEnter() {
      console.log(this.inputMsg)
    },
    async getList() {
      this.listLoading = true
      const { data } = await fetchList(this.listQuery)
      const items = data.items
      this.list = items.map(v => {
        this.$set(v, 'edit', false) // https://vuejs.org/v2/guide/reactivity.html
        v.originalTitle = v.title //  will be used when user click the cancel botton
        return v
      })
      this.listLoading = false
    },
    cancelEdit(row) {
      row.title = row.originalTitle
      row.edit = false
      this.$message({
        message: 'The title has been restored to the original value',
        type: 'warning'
      })
    },
    confirmEdit(row) {
      row.edit = false
      row.originalTitle = row.title
      this.$message({
        message: 'The title has been edited',
        type: 'success'
      })
    }
  }
}
</script>

<style scoped>
  .edit-input {
    padding-right: 100px;
  }
  .cancel-btn {
    position: absolute;
    right: 15px;
    top: 10px;
  }
</style>
