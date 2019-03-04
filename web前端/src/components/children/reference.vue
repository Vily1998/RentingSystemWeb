<template>
<html>
<el-row>
  <el-col :span="1">
      <div>
        <router-link to = "/Calendar"><el-button><i class="el-icon-caret-left"></i> </el-button></router-link>
      </div>
  </el-col>
  <el-col :span="21">
      <div>
          <h1>现有需求</h1> 
      </div>
      <div>
        
        </div>
  </el-col>
</el-row>
    <el-table
    :data="tableData"
    style="width: 100%"
    max-height="700">
    <el-table-column
      label="地区"
      align="left">
      <template slot-scope="scope">
        <i class="el-icon-time"></i>
        <span style="margin-left: 10px">{{ scope.row.gameid}}</span>
      </template>
    </el-table-column>
    <el-table-column
      label="详细地址"
      align="left">
      <template slot-scope="scope">
      <span style="margin-left: 10px">{{ scope.row.status }}</span>
      </template>
    </el-table-column>
    <el-table-column
      label="房型"
      align="left">
      <template slot-scope="scope">
      <span style="margin-left: 10px">{{ scope.row.status }}</span>
      </template>
    </el-table-column>
    <el-table-column label="是否有电梯" align="left">
      <template slot-scope="scope">
      <span style="margin-left: 10px">{{ scope.row.home }}</span>
      </template>
    </el-table-column>
    <el-table-column label="楼层低" align="left">
        <template slot-scope="scope">
      <span style="margin-left: 10px">{{ scope.row.away }}</span>
      </template>
        </el-table-column>
    <el-table-column label="楼层高" align="left">
        <template slot-scope="scope">
      <span style="margin-left: 10px">{{ scope.row.able }}</span>
      </template>
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
    data() {
      return {
        tableData: [

        ]
      }
    },
    methods: {
    check() {
      this.tableData = [];
			this.$axios({
				method:"post",
				url:"/api/match/get_today_match",
				data:{
					
				}
      }).then((res)=>
      {
        var i = 0;
        for(;i<res.data.length;i++)
        {
          var myarray = new Array();
          myarray = res.data[i];
          var bifen = myarray.home_score + ' : ' + myarray.guest_score;
          var status;
          if(myarray.result == 0)
          {
            status = '未开始';
          }
          else if((myarray.result == 1))
          {
            status = '已开始';
          }
          else{
            status = '已结束';
          }
          var able;
          if(myarray.bet_able == 0)
          {
            able = '未开盘';
          }
          else if(myarray.bet_able == 1){
            able = '已开盘';
          }
          else if(myarray.bet_able == 2)
          {
            able = '已封盘';
          }
          var temp = {
            gameid: myarray.match_id,
            status:status,
            home:myarray.home_team,
            bifen:bifen,
            away:myarray.guest_team,
            able:able
          }
          console.log(temp);
          
          this.tableData.push(temp);
          
        }
        console.log(this.tableData);
      })
		}
    },
    mounted:function(){
			this.check()
		}
  }
</script>