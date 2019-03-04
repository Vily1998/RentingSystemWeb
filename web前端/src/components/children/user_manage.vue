<template>
<html>
<el-row>
  <el-col :span="1">
      <div>
        <router-link to = "/home"><el-button><i class="el-icon-caret-left"></i> </el-button></router-link>
      </div>
  </el-col>
  <el-col :span="21">
      <div>
          <h1>用户信息</h1> 

      </div>
  </el-col>
</el-row>
      <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      fixed
      prop="user_id"
      label="用户ID"
      sortable
      width="150">
    </el-table-column>
    <el-table-column
      prop="user_name"
      label="用户名"
      width="120">
    </el-table-column>
    <el-table-column
      prop="password"
      label="密码"
      width="120">
    </el-table-column>
    <el-table-column
      prop="user_type"
      label="用户类型"
      width="120">
    </el-table-column>
    <el-table-column
      prop="real_name"
      label="真实姓名"
      width="300">
    </el-table-column>
    <el-table-column
      prop="certificate_type"
      label="证件类型"
      width="120">
    </el-table-column>
        <el-table-column
      prop="certificate_num"
      label="证件号"
      width="120">
    </el-table-column>
        <el-table-column
      prop="mobile_num"
      label="电话号"
      width="120">
    </el-table-column>
        <el-table-column
      prop="user_level"
      label="用户等级"
      sortable
      width="120">
    </el-table-column>
        <el-table-column
      prop="register_city"
      label="登记城市"
      width="120">
    </el-table-column>
    <el-table-column
      prop="register_time"
      label="登记时间"
      sortable
      width="120">
    </el-table-column>
        <el-table-column
      prop="modify_time"
      label="最近修改时间"
      sortable
      width="120">
    </el-table-column>
  </el-table>
</html>
</template>
<style scoped>
    .el-row{
        background:white
    }
</style>
<script>
  export default {
    methods: {
      handleClick(row) {
        console.log(row);
      }
    },

    data() {
      return {
        tableData:[],
      }
    },
     mounted(){
        this.tableData=[];
        this.$axios({
        method:"post",
        url:'http://localhost:8080/RentHouseSystem/user/AllUserInfo', 
        data:{
        }
        }).then((res) => {
        var tempData=[];
        for(var k=0;k<res.data.length;k++)
        {
          tempData.push(res.data[k]);
        }
        console.log(tempData);
        for(var k=0;k<tempData.length;k++)
        {
          var temp={
            user_id:tempData[k].user_id,
            user_name:tempData[k].user_name,
            password:tempData[k].password,
            user_type:tempData[k].user_type,
            real_name:tempData[k].real_name,
            certificate_type:tempData[k].certificate_type,
            mobile_num:tempData[k].mobile_num,
            user_level:tempData[k].user_level,
            register_city:tempData[k].register_city,
            register_time:tempData[k].register_time,
            modify_time:tempData[k].modify_time,
          }
          console.log(temp)
          this.tableData.push(temp);
        }
        console.log(this.tableData);
      })
  }
  }
</script>