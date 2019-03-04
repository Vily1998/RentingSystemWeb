<template>
  <el-col >
      <div>
        <router-link to = "/"><el-button><i class="el-icon-caret-left"></i> </el-button></router-link>
      </div>
      <div>
            <el-card class="box-card" shadow="hover" body-style="height:1000px">
            <div class="card">
   	<div class="card-body" >
					<form @submit.prevent="onSubmit" class="body">
<el-row>
  <div >
    <el-col :span="1">
    <p>{{hello}}</p>
      </el-col>
  <el-select v-model="city_name" placeholder="选择城市">
    <el-option
      v-for="item in options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>
  </div>
</el-row>
 <el-row>
  <div >
    <el-col :span="1">
    <p>{{hello2}}</p>
      </el-col>
  <div class="block">
    <el-date-picker
      v-model="start_time"
       format="yyyy 年 MM 月 dd 日"
       value-format="yyyy-MM-dd"
      type="daterange"
      range-separator="——"
      start-placeholder="下限"
      end-placeholder="上限"
      unlink-panels='true'>
    </el-date-picker>
  </div>
  </div>
  </el-row>
 <el-row>
  <div >
    <el-col :span="1">
    <p>{{hello3}}</p>
      </el-col>
      <div class="block">
    <el-date-picker
      v-model="end_time"
       format="yyyy 年 MM 月 dd 日"
       value-format="yyyy-MM-dd"
      type="daterange"
      range-separator="——"
      start-placeholder="下限"
      end-placeholder="上限"
      unlink-panels='true'>
    </el-date-picker>
  </div>
  </div>
  </el-row>
    <el-row>
  <div >
    <el-col :span="1">
    <p>{{hello5}}</p>
      </el-col>
<el-input-number v-model="low_fee"></el-input-number>
<span>{{hello4}}</span>
  <el-input-number v-model="high_fee"></el-input-number>

  </div>
  </el-row>
<button type="submit" class="btn btn-block btn-success">查询</button>
	</form> 
      </div>
  </div>



      <el-table
    :data="tableData"
    border
    style="width: 100%">
        <el-table-column
      prop="house_id"
      label="房屋编号"
      sortable
      width="120">
    </el-table-column>
            <el-table-column
      prop="tenant_user_id"
      label="户主id"
      sortable
      width="120">
    </el-table-column>
            <el-table-column
      prop="landlord_user_id"
      label="租户id"
      sortable
      width="120">
    </el-table-column>
            <el-table-column
      prop="start_month"
      label="开始月份"
      sortable
      width="120">
    </el-table-column>
            <el-table-column
      prop="terminate_month"
      label="结束月份"
      sortable
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
      prop="total_rent"
      label="总租金"
      sortable
      width="120">
    </el-table-column>
        <el-table-column
      prop="landord_agency_fee"
      label="中介费用"
      sortable
      width="120">
    </el-table-column>
  </el-table>
  <el-menu
  :default-active="activeIndex2"
  class="el-menu-demo"
  mode="horizontal"
  background-color="#33CCFF"
  text-color="#fff"
  active-text-color="#ffd04b">
  <el-menu-item index="1" ></el-menu-item>
</el-menu>
 <el-select v-model="choice"  @change="handleChange" placeholder="选择分类方式">
    <el-option
      v-for="item in option"
      :key="item.value"
      :label="item.label"
      :value="item.value"
     >
    </el-option>
  </el-select>
   <el-select v-model="output"  @change="handleChange" placeholder="选择查看数据">
    <el-option
      v-for="item in option2"
      :key="item.value"
      :label="item.label"
      :value="item.value"
     >
    </el-option>
  </el-select>
  <div v-if="choice == '1'">
<span>年份</span>
<el-input-number v-model="year" @change="handleChange" label="描述文字"></el-input-number>
  </div>
    <div id="app" v-if="choice == 1">
        <schart :canvasId="canvasId"
            :type="type"
            :width="width"
            :height="height"
            :data="data"
            :options="options1"
        ></schart>
    </div>
        <div id="app" v-if="choice == 2">
        <schart :canvasId="canvasId"
            :type="type2"
            :width="width"
            :height="height"
            :data="data2"
            :options="options2"
        ></schart>
    </div>
            <div id="app" v-if="choice == 3">
        <schart :canvasId="canvasId"
            :type="type2"
            :width="width"
            :height="height"
            :data="data3"
            :options="options2"
        ></schart>
    </div>
        </el-card>
      </div>
  </el-col>
</template>
<style scoped>
    .el-row{
        background:white
    }
      .el-col {
	text-decoration: none;
	font-size: 15px;
}
</style>
<script>
import Schart from 'vue-schart';
export default {
    data() {
        return {
            tableData:[],
          options: [{
          value: '-1',
          label: '无'
        },{
          value: '北京市 ',
          label: '北京市'
        }, {
          value: '天津市 ',
          label: '天津市'
        }, {
          value: '上海市 ',
          label: '上海市'
        }, {
          value: '重庆市 ',
          label: '重庆市'
        }, {
          value: '河北省 ',
          label: '河北省 '
        },
        {
          value: '山西省 ',
          label: '山西省 '
        }, {
          value: '台湾省 ',
          label: '台湾省 '
        }, {
          value: '辽宁省 ',
          label: '辽宁省 '
        }, {
          value: '吉林省 ',
          label: '吉林省 '
        }, {
          value: '黑龙江省 ',
          label: '黑龙江省 '
        },
        {
          value: '江苏省 ',
          label: '江苏省 '
        }, {
          value: '浙江省 ',
          label: '浙江省 '
        }, {
          value: '安徽省 ',
          label: '安徽省 '
        }, {
          value: '福建省 ',
          label: '福建省 '
        }, {
          value: '江西省 ',
          label: '江西省 '
        },
        {
          value: '山东省 ',
          label: '山东省 '
        }, {
          value: '河南省 ',
          label: '河南省 '
        }, {
          value: '湖北省 ',
          label: '湖北省 '
        }, {
          value: '湖南省 ',
          label: '湖南省 '
        }, {
          value: '广东省 ',
          label: '广东省 '
        },
        {
          value: '甘肃省 ',
          label: '甘肃省 '
        }, {
          value: '四川省 ',
          label: '四川省 '
        }, {
          value: '贵州省 ',
          label: '贵州省 '
        }, {
          value: '海南省 ',
          label: '海南省 '
        }, {
          value: '云南省 ',
          label: '云南省 '
        },
        {
          value: '青海省 ',
          label: '青海省 '
        }, {
          value: '陕西省 ',
          label: '陕西省 '
        }, {
          value: '广西壮族自治区 ',
          label: '广西壮族自治区 '
        }, {
          value: '西藏自治区 ',
          label: '西藏自治区 '
        }, {
          value: '宁夏回族自治区 ',
          label: '宁夏回族自治区 '
        },
        {
          value: '新疆维吾尔自治区 ',
          label: '新疆维吾尔自治区 '
        }, {
          value: '内蒙古自治区 ',
          label: '内蒙古自治区 '
        }, {
          value: '澳门特别行政区 ',
          label: '澳门特别行政区 '
        }, {
          value: '香港特别行政区 ',
          label: '香港特别行政区 '
        }],
        value: '',
        start_time:[],
        city_name:"",
        end_time:[],
        low_fee:0,
        high_fee:0,
        year:2019,
                    hello:'城市：',
        hello2:'开始日期：',
        hello3:'结束日期：',
        hello4:'————',
        hello5:'中介费：',
                     option: [{
          value: 1,
          label: '时间收入表'
        }, {
          value: 2,
          label: '地区收入表1'
        },
        {
          value: 3,
          label: '地区收入表2'
        }],
                choice:'',
          option2: [{
          value: 1,
          label: '交易数'
        }, {
          value: 2,
          label: '中介费收入'
        },
        ],
                output:'',
            canvasId: 'myCanvas',
            type: 'line',
            type2:'bar',
            width: 500,
            height: 800,
            data: [
            ],
                  data2: [

            ],
            data3: [

            ],
            options1: {
                title: '按月份统计'
            },
            options2: {
                title: '按地区统计'
            }
        }
    },
    methods:{
      handleChange(value){
        console.log('h'+this.choice);
        while(this.data.length!=0)
        this.data.pop();
        while(this.data2.length!=0)
        this.data2.pop();
        while(this.data3.length!=0)
        this.data3.pop();
        
        if(this.choice==1)
        {if(this.output==2)
        {
        let params = new URLSearchParams();
        params.append('year', this.year.toString());
        this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/transaction/AllMonthIncomeInfo',               
					 data:params,                            
					 }).then(res=> {
             var tempData=[];
        for(var k=0;k<res.data.length;k++)
        {
          tempData.push(res.data[k]);
        }
        console.log(tempData);
        for(var k=0;k<tempData.length;k++)
        {
          var temp={
          name:tempData[k].month,
          value:tempData[k].total_agency_fee,
          }
           temp.name=temp.name.toString();
          temp.value=parseInt(temp.value);
          console.log(temp);
          this.data.push(temp);

           
        }
        console.log(this.data);
           })
        }else if(this.output==1){
        let params = new URLSearchParams();
        params.append('year', this.year.toString());
        this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/transaction/AllMonthIncomeInfo',               
					 data:params,                            
					 }).then(res=> {
             var tempData=[];
        for(var k=0;k<res.data.length;k++)
        {
          tempData.push(res.data[k]);
        }
        console.log(tempData);
        for(var k=0;k<tempData.length;k++)
        {
          var temp={
          name:tempData[k].month,
          value:tempData[k].transaction_num,
          }
           temp.name=temp.name.toString();
          temp.value=parseInt(temp.value);
          console.log(temp);
          this.data.push(temp);

           
        }
        console.log(this.data);
           })
        }
        }
        if(this.choice==2)
        {if(this.output==2)
        {
        this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/transaction/AllAreaIncomeInfo',                                        
					 }).then(res=> {
             var tempData=[];
        for(var k=0;k<res.data.length;k++)
        {
          tempData.push(res.data[k]);
        }
        console.log(tempData);
        for(var k=0;k<17;k++)
        {
          var temp={
          name:tempData[k].area,
          value:tempData[k].total_agency_fee,
          }
           temp.name=temp.name.toString();
          temp.value=parseInt(temp.value);
          console.log(temp);
          this.data2.push(temp);

           
        }
        console.log(this.data);
           })
        }else if(this.output==1){
        this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/transaction/AllAreaIncomeInfo',                                        
					 }).then(res=> {
             var tempData=[];
        for(var k=0;k<res.data.length;k++)
        {
          tempData.push(res.data[k]);
        }
        console.log(tempData);
        for(var k=0;k<17;k++)
        {
          var temp={
          name:tempData[k].area,
          value:tempData[k].transaction_num,
          }
           temp.name=temp.name.toString();
          temp.value=parseInt(temp.value);
          console.log(temp);
          this.data2.push(temp);

           
        }
        console.log(this.data);
           })

        }
        }
        if(this.choice==3)
        {
          if(this.output==2){
        this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/transaction/AllAreaIncomeInfo',                                        
					 }).then(res=> {
             var tempData=[];
        for(var k=0;k<res.data.length;k++)
        {
          tempData.push(res.data[k]);
        }
        console.log(tempData);
        for(var k=17;k<34;k++)
        {
          var temp={
          name:tempData[k].area,
          value:tempData[k].total_agency_fee,
          }
           temp.name=temp.name.toString();
          temp.value=parseInt(temp.value);
          console.log(temp);
          this.data3.push(temp);

           
        }
        console.log(this.data);
           })
        
        }else if(this.output==1){
                  this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/transaction/AllAreaIncomeInfo',                                        
					 }).then(res=> {
             var tempData=[];
        for(var k=0;k<res.data.length;k++)
        {
          tempData.push(res.data[k]);
        }
        console.log(tempData);
        for(var k=17;k<34;k++)
        {
          var temp={
          name:tempData[k].area,
          value:tempData[k].transaction_num,
          }
           temp.name=temp.name.toString();
          temp.value=parseInt(temp.value);
          console.log(temp);
          this.data3.push(temp);

           
        }
        console.log(this.data);
           })
        }
        }
        
      },
 onSubmit(){
        while(this.tableData.length!=0)
        this.tableData.pop();
        let params = new URLSearchParams();
        if(this.city_name!='')
        params.append('city_name', this.city_name);
        else
        params.append('city_name', '-1');
        if(this.start_time.length==0){
        params.append('low_start_time', '-1');
        params.append('high_start_time','-1');
        }
        else{
        params.append('low_start_time', this.start_time[0]);
        params.append('high_start_time',this.start_time[1]);
        }
        if(this.end_time.length==0){
        params.append('low_terminate_time', '-1');
        params.append('high_terminate_time','-1');
        }
        else{
        params.append('low_terminate_time', this.end_time[0]);
        params.append('high_terminate_time',this.end_time[1]);
        }
        if(this.low_fee!=0)
        params.append('low_agency_fee', this.low_fee);
        else
        params.append('low_agency_fee', -1);
        if(this.high_fee!=0)
        params.append('high_agency_fee', this.high_fee);
        else
        params.append('high_agency_fee', -1);
                console.log(this.community_name);
					this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/transaction/SelectTransaction',               
					 data:params,                            
					 }).then(res=> {
						
		var tempData=[];
        for(var k=0;k<res.data.length;k++)
        {
          tempData.push(res.data[k]);
        }
        console.log(tempData);
        for(var k=0;k<tempData.length;k++)
        {
          var temp={
      house_id:res.data[k].house_id,  
    
      landlord_user_id:res.data[k].landlord_user_id,
    
      tenant_user_id:res.data[k].tenant_user_id,
    
       transaction_date:res.data[k].transaction_date,
    
       start_month:res.data[k].start_month,
    
       terminate_month:res.data[k].terminate_month,
    
       deposit:res.data[k].deposit,
     
      payment_method:res.data[k].payment_method,
    
       rent_per_month:res.data[k].rent_per_month,
    
       total_rent:res.data[k].total_rent,
    
       landord_agency_fee:res.data[k].landord_agency_fee,
    
       tenant_agency_fee:res.data[k].tenant_agency_fee
          }
                    if(temp.payment_method==1)
          temp.payment_method='月';
          if(temp.payment_method==2)
          temp.payment_method='季';
          if(temp.payment_method==3)
          temp.payment_method='年';
          console.log(temp);
          this.tableData.push(temp);
        }
        
        console.log(this.tableData);
					})
       },
    },

    components:{
        Schart
    }
}
</script>