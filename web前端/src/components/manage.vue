<template>
  <div>
      <div class="line"></div>
      <!--router-link @click.native="handleDelete('000',flag);addone()" :to="{path:this.$store.state.count}">{{this.$store.state.count}}</router-link-->
          <el-menu
            :default-active="activeIndex2"
            class="el-menu-demo"
            mode="horizontal"
            @select="handleSelect"
            background-color="#ff4000"
            text-color="#fff"
            active-text-color="#ffd04b">
            <el-menu-item index="1" @click="changelink('/')">主页</el-menu-item>
            <el-submenu index="2">
              <template slot="title">个人管理</template>
              <el-menu-item index="2-1" @click="changelink('/win_lose')">我的房源</el-menu-item>
              <el-menu-item index="2-2" @click="changelink('/goal')">租房申请</el-menu-item>
              <el-menu-item index="2-3" @click="changelink('/total')">租房需求</el-menu-item>
              <el-menu-item index="2-3" @click="changelink('/give_ball')">现有房源</el-menu-item>
            </el-submenu>
          </el-menu>
          <el-card class="box-card" shadow="hover" body-style="height:800px">
            <el-row>
  <div >
    <el-col :span="1">
    <p>{{hello}}</p>
      </el-col>
    <el-radio-group v-model="radio3"  >
      <el-radio-button label="东城"></el-radio-button>
      <el-radio-button label="西城"></el-radio-button>
      <el-radio-button label="海淀"></el-radio-button>
      <el-radio-button label="丰台"></el-radio-button>
      <el-radio-button label="朝阳"></el-radio-button>
      <el-radio-button label="昌平"></el-radio-button>
      <el-radio-button label="大兴"></el-radio-button>
    </el-radio-group>
  </div>
  </el-row>
 <el-row>
  <div >
    <el-col :span="1">
    <p>{{hello2}}</p>
      </el-col>
      <el-col :span="2">
<el-input v-model="input" placeholder="请输入具体位置"></el-input>
</el-col>
  </div>
  </el-row>
  <el-row>
  <div >
    <el-col :span="1">
    <p>{{hello3}}</p>
      </el-col>
      <el-col :span="2" >
<el-input v-model="input" style="width:120px;position:aboslute;	left:7px;"></el-input>
</el-col>
  </div>
  </el-row>
    <el-row>
  <div >
    <el-col :span="1">
    <p>{{hello5}}</p>
      </el-col>
    <el-radio-group v-model="radio2" id='s1' >
      <el-radio :label="3">一居</el-radio>
      <el-radio :label="6">两居</el-radio>
      <el-radio :label="9">三居</el-radio>
      <el-radio :label="12">四居+</el-radio>
    </el-radio-group>
  </div>
  </el-row>
     <el-row>
  <div >
    <el-col :span="1">
    <p>{{hello6}}</p>
      </el-col>
    <el-radio-group v-model="radio2" id='s2' >
      <el-radio :label="3">是</el-radio>
      <el-radio :label="6">否</el-radio>
    </el-radio-group>
  </div>
  </el-row>
    <el-row>
  <div >
    <el-col :span="1">
    <p>{{hello7}}</p>
      </el-col>
      <el-col :span="2" >
<el-input v-model="input" style="width:120px;position:aboslute;	left:7px;"></el-input>
</el-col>
  </div>
  </el-row>
    <el-row>
  <div >
    <el-col :span="1">
    <p>{{hello8}}</p>
      </el-col>
      <el-col :span="2" >
<el-input v-model="input" style="width:120px;position:aboslute;	left:7px;"></el-input>
</el-col>
  </div>
  </el-row>
  <el-row>
    <el-col :span='1'>
       <p>{{hello9}}</p>
    </el-col>
    <el-col :span='2'>
  <el-upload
  action="https://jsonplaceholder.typicode.com/posts/"
  list-type="picture-card"
  :on-preview="handlePictureCardPreview"
  :on-remove="handleRemove"
  >
  <i class="el-icon-plus"></i>
</el-upload>
<el-dialog :visible.sync="dialogVisible">
  <img width="100%" :src="dialogImageUrl" alt="">
</el-dialog>
    </el-col>
  </el-row>
  <el-row>
  <div id="logons">
				<el-button type="primary" @click.native.prevent="handleSubmit">发布房源</el-button>
				</div>
  </el-row>
</el-card>
  </div>
  </template>
  
<script>
  import util from '../util.js'
    export default {
      data() {
        return {
          use:1,
          tableData: [],
          flag :"calendar",
          sendData:[],
          lotteryData:[],
                  hello:'地区：',
        hello2:'街区：',
        hello3:'价格：',
        hello4:'————',
        hello5:'房型：',
        hello6:'是否电梯：',
        hello7:'楼层:',
        hello8:'规格:',
        hello9:'图片:',
                dialogImageUrl: '',
        dialogVisible: false
        }
      },
      mounted(){
        this.tableData=[];
        this.$axios({
        method:"post",
        url:'/api/bet/get_score_lot', 
        data:{
        }
        }).then((res) => {
        var tempData=[];
        for(var k=0;k<res.data.length;k++)
        {
          tempData.push(res.data[k]);
        }
        for(var k=0;k<tempData.length;k++)
        {
          var temp=tempData[k];
          temp["rowflag"]=0;
          temp["colflag"]=0;
          temp["flag"]=[];
          temp["date"]=util.formatDate.format(new Date(tempData[k].time),'yyyy-MM-dd');
          temp["time"]=util.formatDate.format(new Date(tempData[k].time),'hh:mm:ss');
          temp["oddsData"]=[];
          for(var p=0;p<6;p++)
          {
            var temp1={odds0:0,odds1:0,odds2:0,odds3:0,odds4:0,odds5:0};
            temp.oddsData.push(temp1);
          }
          temp.oddsData[0].odds0=tempData[k].b0to0_odds;
          temp.oddsData[0].odds1=tempData[k].b0to1_odds;
          temp.oddsData[0].odds2=tempData[k].b0to2_odds;
          temp.oddsData[0].odds3=tempData[k].b0to3_odds;
          temp.oddsData[0].odds4=tempData[k].b0to4_odds;
          temp.oddsData[0].odds5=tempData[k].b0to5_odds;
          temp.oddsData[1].odds0=tempData[k].b1to0_odds;
          temp.oddsData[1].odds1=tempData[k].b1to1_odds;
          temp.oddsData[1].odds2=tempData[k].b1to2_odds;
          temp.oddsData[1].odds3=tempData[k].b1to3_odds;
          temp.oddsData[1].odds4=tempData[k].b1to4_odds;
          temp.oddsData[1].odds5=tempData[k].b1to5_odds;
          temp.oddsData[2].odds0=tempData[k].b2to0_odds;
          temp.oddsData[2].odds1=tempData[k].b2to1_odds;
          temp.oddsData[2].odds2=tempData[k].b2to2_odds;
          temp.oddsData[2].odds3=tempData[k].b2to3_odds;
          temp.oddsData[2].odds4=tempData[k].b2to4_odds;
          temp.oddsData[2].odds5=tempData[k].b2to5_odds;
          temp.oddsData[3].odds0=tempData[k].b3to0_odds;
          temp.oddsData[3].odds1=tempData[k].b3to1_odds;
          temp.oddsData[3].odds2=tempData[k].b3to2_odds;
          temp.oddsData[3].odds3=tempData[k].b3to3_odds;
          temp.oddsData[3].odds4=null
          temp.oddsData[3].odds5=null
          temp.oddsData[4].odds0=tempData[k].b4to0_odds;
          temp.oddsData[4].odds1=tempData[k].b4to1_odds;
          temp.oddsData[4].odds2=tempData[k].b4to2_odds;
          temp.oddsData[4].odds3=null
          temp.oddsData[4].odds4=null
          temp.oddsData[4].odds5=null
          temp.oddsData[5].odds0=tempData[k].b5to0_odds;
          temp.oddsData[5].odds1=tempData[k].b5to1_odds;
          temp.oddsData[5].odds2=tempData[k].b5to2_odds;
          temp.oddsData[5].odds3=null
          temp.oddsData[5].odds4=null
          temp.oddsData[5].odds5=null
          for(var p=0;p<31;p++)
          {
            var flagtemp={flagi:1}
            temp.flag[p]=flagtemp;
          }
          this.tableData.push(temp);
        }
        console.log(this.tableData);
      })
      },
      methods: {
        handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePictureCardPreview(file) {
        this.dialogImageUrl = file.url;
        this.dialogVisible = true;
      },
        changelink(route){
            this.$router.replace(route);
        },
        cal(ddd){
          alert(ddd);
          var tt=parseInt(ddd)*6+parseInt(1);
          return tt;
        },
        addone: function () {
          this.$store.commit("increment");
        },
        returndata:function(){
          return lotteryData
        },
        handleEdit(index, row) {
          url="www.baidu.com"
        },
        open2(team) {
        this.$confirm('是否查看该球队信息?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.changelink('team/'+ team );
        }).catch(() => {         
        });
        },
        handleDelete(index, row) {
          this.flag=index;
          this.$route.path='123'
          console.log(index, row);
        },
        buylottery(info){
          var temp={
            colflag:info.colflag,
            guest_team:info.guest_team,
            home_team:info.home_team,
            match_id:info.match_id,
            oddsData:info.oddsData,
            rowflag:info.rowflag,
            type:"warning",
            colflag:info.colflag,
            otherwin_odds:info.otherwin_odds,
            otherdraw_odds:info.otherdraw_odds,
            otherlose_odds:info.otherlose_odds,
            bet_able:info.bet_able,
            result:info.result
          }
          this.lotteryData.push(temp);
          this.update();
          this.$router.replace('/goal/lottery');
        },
        deletelottery(info){
          var index3;
          var index2;
          for(var i=0;i<this.lotteryData.length;i++){
            if((info.match_id==this.lotteryData[i].match_id)&&(info.rowflag==this.lotteryData[i].rowflag)&&(info.colflag=this,lotteryData[i].colflag))
            {
              index3=i;
            }
          }
          for(var j=0;j<this.tableData.length;j++){
            if(info.match_id==this.tableData[j].match_id)
            {
              index2=j;
            }
          }
          if(info.type=="success")
            this.tableData[index2].flag1=1;
          else if(info.type=="warning")
            this.tableData[index2].flag2=1;
          else if(info.type=="danger")
            this.tableData[index2].flag3=1;
          this.lotteryData.splice(index3,1);
          this.update();
          this.$router.replace('/goal/lottery');
        },
        update(){
          console.log(this.lotteryData)
        this.sendData=[];
        var oddd;
        var choicee;
        for(var i=0;i<this.lotteryData.length;i++){
          if(this.lotteryData[i].colflag==1){
            oddd=this.lotteryData[i].oddsData[this.lotteryData[i].rowflag-1].odds0;
            if(this.lotteryData[i].rowflag==1)
              choicee="b0to0_odds"
            if(this.lotteryData[i].rowflag==2)
              choicee="b1to0_odds"
            if(this.lotteryData[i].rowflag==3)
              choicee="b2to0_odds"
            if(this.lotteryData[i].rowflag==4)
              choicee="b3to0_odds"
            if(this.lotteryData[i].rowflag==5)
              choicee="b4to0_odds"
            if(this.lotteryData[i].rowflag==6)
              choicee="b5to0_odds"
          }
          if(this.lotteryData[i].colflag==2){
            oddd=this.lotteryData[i].oddsData[this.lotteryData[i].rowflag-1].odds1;
            if(this.lotteryData[i].rowflag==1)
              choicee="b0to1_odds"
            if(this.lotteryData[i].rowflag==2)
              choicee="b1to1_odds"
            if(this.lotteryData[i].rowflag==3)
              choicee="b2to1_odds"
            if(this.lotteryData[i].rowflag==4)
              choicee="b3to1_odds"
            if(this.lotteryData[i].rowflag==5)
              choicee="b4to1_odds"
            if(this.lotteryData[i].rowflag==6)
              choicee="b5to1_odds"
          }
          if(this.lotteryData[i].colflag==3){
            oddd=this.lotteryData[i].oddsData[this.lotteryData[i].rowflag-1].odds2;
            if(this.lotteryData[i].rowflag==1)
              choicee="b0to2_odds"
            if(this.lotteryData[i].rowflag==2)
              choicee="b1to2_odds"
            if(this.lotteryData[i].rowflag==3)
              choicee="b2to2_odds"
            if(this.lotteryData[i].rowflag==4)
              choicee="b3to2_odds"
            if(this.lotteryData[i].rowflag==5)
              choicee="b4to2_odds"
            if(this.lotteryData[i].rowflag==6)
              choicee="b5to2_odds"
          }
          if(this.lotteryData[i].colflag==4){
            oddd=this.lotteryData[i].oddsData[this.lotteryData[i].rowflag-1].odds3;
            if(this.lotteryData[i].rowflag==1)
              choicee="b0to3_odds"
            if(this.lotteryData[i].rowflag==2)
              choicee="b1to3_odds"
            if(this.lotteryData[i].rowflag==3)
              choicee="b2to3_odds"
            if(this.lotteryData[i].rowflag==4)
              choicee="b3to3_odds"
            if(this.lotteryData[i].rowflag==5)
              choicee="b4to3_odds"
            if(this.lotteryData[i].rowflag==6)
              choicee="b5to3_odds"
          }
          if(this.lotteryData[i].colflag==5){
            oddd=this.lotteryData[i].oddsData[this.lotteryData[i].rowflag-1].odds4;
            if(this.lotteryData[i].rowflag==1)
              choicee="b0to4_odds"
            if(this.lotteryData[i].rowflag==2)
              choicee="b1to4_odds"
            if(this.lotteryData[i].rowflag==3)
              choicee="b2to4_odds"
            if(this.lotteryData[i].rowflag==4)
              choicee="b3to4_odds"
            if(this.lotteryData[i].rowflag==5)
              choicee="b4to4_odds"
            if(this.lotteryData[i].rowflag==6)
              choicee="b5to4_odds"
          }
          if(this.lotteryData[i].colflag==6){
            oddd=this.lotteryData[i].oddsData[this.lotteryData[i].rowflag-1].odds5;
            if(this.lotteryData[i].rowflag==1)
              choicee="b0to5_odds"
            if(this.lotteryData[i].rowflag==2)
              choicee="b1to5_odds"
            if(this.lotteryData[i].rowflag==3)
              choicee="b2to5_odds"
            if(this.lotteryData[i].rowflag==4)
              choicee="b3to5_odds"
            if(this.lotteryData[i].rowflag==5)
              choicee="b4to5_odds"
            if(this.lotteryData[i].rowflag==6)
              choicee="b5to5_odds"
          }
          if(this.lotteryData[i].colflag==7){
            if(this.lotteryData[i].rowflag==1){
              oddd=this.lotteryData[i].otherwin_odds;
              choicee="otherwin_odds";
            }
            if(this.lotteryData[i].rowflag==2){
              choicee="otherdraw_odds";
              oddd=this.lotteryData[i].otherdraw_odds;
            }
            if(this.lotteryData[i].rowflag==3){
              choicee="otherlose_odds";
              oddd=this.lotteryData[i].otherlose_odds;
            }
          }
            var temp={
            match_id:this.lotteryData[i].match_id,
            home_team:this.lotteryData[i].home_team,
            guest_team:this.lotteryData[i].guest_team,
            rowflag:this.lotteryData[i].rowflag,
            colflag:this.lotteryData[i].colflag,
            odds:oddd,
            type:'success',
            choice:choicee,
            bet_able:this.lotteryData[i].bet_able,
            result:this.lotteryData[i].result
          }
            this.sendData.push(temp);
        }
        }
      }
    }
  </script>

<style>
  @import url("//unpkg.com/element-ui@2.4.4/lib/theme-chalk/index.css");
      #logons{
	position : absolute;
	left:250px;
  top:30px;
  }
  .el-col {
	text-decoration: none;
	font-size: 15px;
}
</style>