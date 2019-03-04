<style scoped>
@import 'vue2-animate/dist/vue2-animate.min.css';
@import url("//unpkg.com/element-ui@2.4.4/lib/theme-chalk/index.css");
 * {
  box-sizing: border-box;
  }
   
  ul {
  list-style-type: none;
  }
  #input2{
	position : absolute;
	left:10px;
	top:87px
  }
#logon{
	position : absolute;
	left:200px;
  top:87px;
  }
  body {
  font-family: Verdana, sans-serif;
  background: #E8F0F3;
  }
  #calendar{
  width:80%;
  margin: 0 auto;
  box-shadow: 0 2px 2px 0 rgba(0,0,0,0.14), 0 3px 1px -2px rgba(0,0,0,0.1), 0 1px 5px 0 rgba(0,0,0,0.12);
  }
  .month {
  width: 100%;
  background: #00B8EC;
  }
   
  .month ul {
  margin: 0;
  padding: 0;
  display: flex;
  justify-content: space-between;
  }
   
  .year-month {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-around;
  }
   
  .year-month:hover {
  background: rgba(150, 2, 12, 0.1);
  }
   
  .choose-year {
  padding-left: 20px;
  padding-right: 20px;
  }
   
  .choose-month {
  text-align: center;
  font-size: 1.5rem;
  }
   
  .arrow {
  padding: 15px;
  }
   
  .arrow:hover {
  background: rgba(100, 2, 12, 0.1);
  }
   
  .month ul li {
  color: white;
  font-size: 20px;
  text-transform: uppercase;
  letter-spacing: 3px;
  }
   
  .weekdays {
  margin: 0;
  padding: 10px 0;
  background-color: #00B8EC;
  display: flex;
  flex-wrap: wrap;
  color: #FFFFFF;
  justify-content: space-around;
  }
   
  .weekdays li {
  display: inline-block;
  width: 13.6%;
  text-align: center;
  }
   
  .days {
  padding: 0;
  background: #FFFFFF;
  margin: 0;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  }
   
  .days li {
  list-style-type: none;
  display: inline-block;
  width: 14.2%;
  text-align: center;
  padding-bottom: 15px;
  padding-top: 15px;
  font-size: 1rem;
  color: #000;
  }
   
  .days li .active {
  padding: 6px 10px;
  border-radius: 50%;
  background: #00B8EC;
  color: #fff;
  }
   
  .days li .other-month {
  padding: 5px;
  color: gainsboro;
  }
   
  .days li:hover {
  background: #e1e1e1;
  }
  .el-carousel__item h3 {
    color: #475669;
    font-size: 18px;
    opacity: 0.75;
    line-height: 300px;
    margin: 0;
  }
  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }
  
  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }
</style>

<template>
  <div>
      <div>
                  <el-menu
            :default-active="activeIndex2"
            class="el-menu-demo"
            mode="horizontal"
            @select="handleSelect"
            background-color="#00B8EC"
            text-color="#fff"
            active-text-color="#ffd04b">
            <el-menu-item index="1" @click="changelink('/manage2')">返回</el-menu-item>
          </el-menu>
      </div>

<el-col :span="24"><div class="grid-content bg-purple-dark">
<el-card class="box-card" shadow="hover" body-style="height:500px">
    		<div id="input2">
				<el-input v-model="house_id" placeholder="输入ID开始找房" type="text" auto-complete="off"></el-input>
				</div>
        	<div id="logon">
				<el-button type="success" @click.native.prevent="handleSubmit">确认</el-button>
				</div>
              <div slot="header" class="clearfix">
                        <br><br>        
      <span>已经为你搜索到以下房源</span>
    </div>
      <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      prop="city_name"
      label="城市"
      width="150">
    </el-table-column>
    <el-table-column
      prop="community_name"
      label="街区"
      width="120">
    </el-table-column>
    <el-table-column
      prop="house_num"
      label="门牌号"
      width="120">
    </el-table-column>
    <el-table-column
      prop="house_type"
      label="房型"
      width="120">
    </el-table-column>
    <el-table-column
      prop="house_area"
      label="面积"
      sortable
      width="300">
    </el-table-column>
    <el-table-column
      prop="house_floor"
      label="楼层"
      sortable
      width="120">
    </el-table-column>
        <el-table-column
      prop="is_elevator"
      label="是否有电梯"
      width="120">
    </el-table-column>
        <el-table-column
      prop="description"
      label="描述"
      width="120">
    </el-table-column>
        <el-table-column
      prop="deposit"
      label="押金"
      sortable
      width="120">
    </el-table-column>
        <el-table-column
      prop="payment_method"
      label="支付方式"
      width="120">
    </el-table-column>
    <el-table-column
      prop="rent_per_month"
      label="月租金"
      sortable
      width="120">
    </el-table-column>
            <el-table-column
      prop="state"
      label="状态"
      width="120">
    </el-table-column>
         <el-table-column
      fixed="right"
      label="照片"
      width="80">
      <template slot-scope="scope">
        <el-button
          @click.native.prevent=" photo(scope.row)"
          type="text"
          size="small">
          查看
        </el-button>
      </template>
    </el-table-column>
  </el-table>
  </el-card>
  </div>
</el-col>
</div>
</template>

<script>
export default
{

  data(){
    return{
   tableData: [],
   house_id:0,
   }
  },


  methods:{
  changelink(route){
    this.$router.replace(route);
  },
  handleSubmit(){
        while(this.tableData.length!=0)
        this.tableData.pop();
     let params = new URLSearchParams();
                    params.append('house_id', this.house_id);
					this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/house/SelectHouseByHouseId',               
					 data:params,                            
					 }).then(res=> {
						
						var tempData=[];
          tempData.push(res.data);
          if(res != null){
        console.log(tempData);
          var temp={
            house_id:tempData[0].house_id,
            city_name:tempData[0].city_name,
            community_name:tempData[0].community_name,
            house_num:tempData[0].house_num,
            house_type:tempData[0].house_type,
            house_area:tempData[0].house_area,
            house_floor:tempData[0].house_floor,
            is_elevator:tempData[0].is_elevator,
            description:tempData[0].description,
            deposit:tempData[0].deposit,
            payment_method:tempData[0].payment_method,
            rent_per_month:tempData[0].rent_per_month,
            state:tempData[0].state
            }
          console.log(temp)
          if(temp.house_type==1)
          temp.house_type='一居';
          if(temp.house_type==2)
          temp.house_type='二居';
          if(temp.house_type==3)
          temp.house_type='三居';
          if(temp.house_type==4)
          temp.house_type='四居+';
          if(temp.is_elevator==1)
          temp.is_elevator='有';
          if(temp.is_elevator==0)
          temp.is_elevator='无';
          if(temp.payment_method==1)
          temp.payment_method='月';
          if(temp.payment_method==2)
          temp.payment_method='季';
          if(temp.payment_method==3)
          temp.payment_method='年';
          if(temp.state==1)
          temp.state='已出租';
          if(temp.state==0)
          temp.state='未出租';

          this.tableData.push(temp);
          }
          else
          {
            this.$message({message: '未找到房屋',type: 'error'});
          }
        })
  },
        photo(row){
        this.$router.push({
                    path:"/photowall",//跳转路由
                    query:{//参数对象
                        house_id:row.house_id,
                        type:2,
                    }

      })
      }
  }

  }
 </script>