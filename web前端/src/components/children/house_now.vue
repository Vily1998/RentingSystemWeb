<template>
<html>
<el-row>
  <el-col :span="1">
      <div>
        <router-link to = "/"><el-button><i class="el-icon-caret-left"></i> </el-button></router-link>
      </div>
  </el-col>
   <br><br>
</el-row>
   
        <el-card class="box-card" shadow="hover" body-style="height:400px">
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
      <el-col :span="2">
<el-input v-model="community_name" placeholder="请输入具体位置"></el-input>
</el-col>
  </div>
  </el-row>
 <el-row>
  <div >
    <el-col :span="1">
    <p>{{hello3}}</p>
      </el-col>
      <el-col :span="2" >
<el-input v-model="min_area" style="width:120px;position:aboslute;"></el-input>
</el-col>
 <el-col :span="3" >
    <p>{{hello4}}</p>
    </el-col>
     <el-col :span="4" >
<el-input v-model="max_area" style="width:120px;position:aboslute;	left:-120px;"></el-input>
</el-col>
  </div>
  </el-row>
    <el-row>
  <div >
    <el-col :span="1">
    <p>{{hello5}}</p>
      </el-col>
    <el-radio-group v-model="house_type" id='s1' >
      <el-radio :label="1">一居</el-radio>
      <el-radio :label="2">两居</el-radio>
      <el-radio :label="3">三居</el-radio>
      <el-radio :label="4">四居+</el-radio>
    </el-radio-group>
  </div>
  </el-row>
     <el-row>
  <div >
    <el-col :span="1">
    <p>{{hello6}}</p>
      </el-col>
    <el-radio-group v-model="is_elevator" id='s2' >
      <el-radio :label="1">是</el-radio>
      <el-radio :label="0">否</el-radio>
    </el-radio-group>
  </div>
      </el-row>
<button type="submit" class="btn btn-block btn-success">查询</button>
	</form> 

  </div>
  </div>
        </el-card>
  
      <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      fixed
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
      prop="modify_time"
      label="最近修改时间"
      sortable
      width="120">
    </el-table-column>
            <el-table-column
      prop="state"
      label="状态"
      width="120">

    </el-table-column>
  </el-table>
      <el-pagination :page-size="pagination.pageSize" @current-change="currentChange"
                            :current-page="pagination.pageNumber"
                            :page-sizes="pagination.pageSizes"
                            :total="pagination.totalRows"
                            :layout="pagination.layout"
                            @size-change='sizeChange'>
    </el-pagination>
</html>
</template>
<style scoped>
.el-pagination {
    background: none;
    text-align: right;
    margin-top: 10px;
}
    .el-row{
        background:white
    }
      .el-col {
	text-decoration: none;
	font-size: 15px;
}
</style>
<script>
  export default {
         data() {
      return {
        tableData:[],
                totalData:[],
        pagination: {
        totalRows: 0, //总条数
        pageSize: 10, //每页显示条数
        pageSizes: [10, 20, 50],
        pageNumber: 1,
        layout: "total, sizes, prev, pager, next, jumper"
      },
          options: [
            {
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
      
city_name: '',
community_name: '',
min_area:0,
max_area:0,
is_elevator: -1,
house_type: 0,
        hello:'城市：',
        hello2:'街区：',
        hello3:'面积：',
        hello4:'————',
        hello5:'房型：',
        hello6:'是否电梯：',
        city:'选择城市'
      }
    },
    methods: {
            currentChange(val) {
      // 改变页的时候调用一次
      this.pagination.pageNumber = val;
      this.queryData();
    },
            sizeChange(val) {
      // 改变每页显示条数的时候调用一次
      this.pagination.pageSize = val;
      this.queryData();
    },
        queryData() {
      // start-----模拟动态分页
      this.tableData = []
      this.pagination.totalRows = this.totalData.length;
      let i = (this.pagination.pageNumber - 1) * this.pagination.pageSize 
      let max = Math.min(this.pagination.pageNumber * this.pagination.pageSize,this.totalData.length-1)
      for (; i <= max; i ++) {
        this.tableData.push(this.totalData[i])
      }
      // end------模拟动态分页
     },
      onSubmit(){
        while(this.totalData.length!=0)
        this.totalData.pop();
        let params = new URLSearchParams();
        if(this.city_name!='')
        params.append('city_name', this.city_name);
        else
        params.append('city_name', '-1');
        if(this.community_name!='')          
        params.append('community_name', this.community_name);
        else
        params.append('community_name', '-1');
        if(this.house_type!=0)
        params.append('house_type', this.house_type);
        else
        params.append('house_type', -1);
        if(this.max_area!=0)
        params.append('max_house_area', this.max_area);
        else
        params.append('max_house_area', -1);
        if(this.min_area!=0)
        params.append('min_house_area', this.min_area);
        else
        params.append('min_house_area', -1);
				params.append('house_num', '-1');
        params.append('house_floor', -1);
        if(this.is_elevator!=-1)
        params.append('is_elevator', this.is_elevator);
        else
         params.append('is_elevator', -1);
        params.append('description', '-1');
        params.append('payment_method', -1);
				params.append('low_rent_per_month', -1);
                params.append('high_rent_per_month', -1);
                params.append('state', -1); 
                console.log(this.community_name);
					this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/house/SelectHouse',               
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
            city_name:tempData[k].city_name,
            community_name:tempData[k].community_name,
            house_num:tempData[k].house_num,
            
            house_type:tempData[k].house_type,
            house_area:tempData[k].house_area,
            house_floor:tempData[k].house_floor,
            is_elevator:tempData[k].is_elevator,
            description:tempData[k].description,
            deposit:tempData[k].deposit,
            payment_method:tempData[k].payment_method,
            rent_per_month:tempData[k].rent_per_month,
            modify_time:tempData[k].modify_time,
            state:tempData[k].state
          }
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

          console.log(temp)
          this.totalData.push(temp);
        }
                        this.pagination.pageNumber = 1;
      this.queryData();
        console.log(this.tableData);
					})
			
  }
    },
            	mounted(){
			this.onSubmit()
		}
  }
</script>
