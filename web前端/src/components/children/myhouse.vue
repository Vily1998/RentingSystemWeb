<template>
<html>
  <el-row>
<el-menu
  :default-active="activeIndex2"
  class="el-menu-demo"
  mode="horizontal"
  @select="handleSelect"
  background-color="#ff4000"
  text-color="#fff"
  active-text-color="#ffd04b">
  <el-menu-item index="1" @click="changelink('/')">主页</el-menu-item>
  <el-menu-item index="2" @click="changelink('/mydemand')">我的需求</el-menu-item>
<el-menu-item index="3"  @click="changelink('/user_information')">账号信息</el-menu-item>
           <el-submenu index="4">
              <template slot="title">我的租房订单</template>
              <el-menu-item index="4-1" @click="changelink('/unaffirm')">房主未确认</el-menu-item>
              <el-menu-item index="4-2" @click="changelink('/uncomplete')">未支付</el-menu-item>
              <el-menu-item index="4-3" @click="changelink('/have_done')">已完成</el-menu-item>
            </el-submenu>
           <el-submenu index="5">
              <template slot="title">我的出租订单</template>
              <el-menu-item index="5-1" @click="changelink('/rent_apply')">租房申请</el-menu-item>
              <el-menu-item index="5-2" @click="changelink('/have_done2')">已完成</el-menu-item>
            </el-submenu>
            <el-menu-item index="6"  @click="changelink('/pay')">我的缴费</el-menu-item>
             <el-menu-item index="6"  @click="changelink('/message')">查看留言</el-menu-item>
</el-menu>
</el-row>
<el-row>
    <el-col :span="21">
      <div>
          <h1>我的房源</h1> 
      </div>
      <div>
        
        </div>
  </el-col>
</el-row>

		<el-dialog title="编辑" :visible.sync="editFormVisible" :close-on-click-modal="true">

			<el-form :model="editForm" label-width="80px" :rules="editFormRules" ref="editForm">

				<el-form-item label="城市" prop="name">

					<el-input v-model="editForm.ecity_name" auto-complete="off"></el-input>

				</el-form-item>

				<el-form-item label="街区">

					<el-input v-model="editForm.ecommunity_name"></el-input>

				</el-form-item>

				<el-form-item label="门牌号">

					<el-input v-model="editForm.ehouse_num"></el-input>

				</el-form-item>

				<el-form-item label="房型">

					    <el-radio-group v-model="editForm.ehouse_type" id='s1' >
      <el-radio :label="1">一居</el-radio>
      <el-radio :label="2">两居</el-radio>
      <el-radio :label="3">三居</el-radio>
      <el-radio :label="4">四居+</el-radio>
    </el-radio-group>

				</el-form-item>
        				<el-form-item label="面积" prop="name">

					<el-input-number v-model="editForm.ehouse_area" auto-complete="off"></el-input-number>

				</el-form-item>

				<el-form-item label="楼层">

					<el-input-number v-model="editForm.ehouse_floor"></el-input-number>

				</el-form-item>

				<el-form-item label="是否有电梯">

				<el-radio-group v-model="editForm.eis_elevator" id='s2' >
      <el-radio :label="1">是</el-radio>
      <el-radio :label="0">否</el-radio>
    </el-radio-group>

				</el-form-item>

				<el-form-item label="描述">

					<el-input type="textarea" v-model="editForm.edescription"></el-input>

				</el-form-item>
        				<el-form-item label="押金" prop="name">

					<el-input-number v-model="editForm.edeposit" auto-complete="off"></el-input-number>

				</el-form-item>

				<el-form-item label="支付方式">

				<el-radio-group v-model="editForm.epayment_method" id='s3' >
      <el-radio :label="1">月</el-radio>
      <el-radio :label="2">季</el-radio>
      <el-radio :label="3">年</el-radio>
    </el-radio-group>

				</el-form-item>

				<el-form-item label="月租金">

					<el-input-number v-model="editForm.erent_per_month"></el-input-number>

				</el-form-item>

			</el-form>

			<div slot="footer" class="dialog-footer">

				<el-button @click.native="editFormVisible = false">取消</el-button>

				<el-button type="primary" @click.native="editSubmit" >提交      </el-button>

			</div>

		</el-dialog>

      <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      prop="house_id"
      label="房屋编号"
      sortable
      width="150">
    </el-table-column>
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
    <el-table-column
      fixed="right"
      label="操作"
      width="120">
      <template slot-scope="scope">
        <el-button
          @click.native.prevent=" handleEdit(scope.$index,scope.row,tableData)"
          type="text"
          size="small">
          编辑
        </el-button>
        <el-button
          size="mini"
          type="danger"
          @click.native.prevent="handleDelete(scope.$index, scope.row,tableData)">删除</el-button>
      </template>
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
    .el-row{
        background:white
    }
      .el-col {
	text-decoration: none;
	font-size: 15px;
}
.el-pagination {
    background: none;
    text-align: right;
    margin-top: 10px;
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
				editForm: {
          ehouse_id:0,
            ecity_name:'',
            ecommunity_name:'',
            ehouse_num:0,
            ehouse_type:0,
            ehouse_area:0,
            ehouse_floor:0,
            eis_elevator:0,
            edescription:'',
            edeposit:0,
            epayment_method:0,
            erent_per_month:0,
            emodify_time:'',
            estate:0,

        },
        editFormVisible:false,
        eindex:0,
      
      }
    },
    methods: {
              changelink(route){
    this.$router.replace(route);
  },
  getmessage(){
                      let params = new URLSearchParams();
                    params.append('user_id', this.$store.state.id);
					this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/rent/CheckMessageNum',               
					 data:params,                            
					 }).then(res=> {
             console.log(res.data);
                      if(res.data!=0)
                       this.$notify({
                    title: '新消息',
                     message: '你有'+res.data+'条新消息'
        });
           })
           					this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/want/CheckWantNum',               
					 data:params,                            
					 }).then(res=> {
             console.log(res.data);
                      if(res.data!=0)
                       this.$notify({
                    title: '租房申请',
                     message: '你有'+res.data+'条租房申请'
        });
           })
           					this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/want/CheckAgreeNum',               
					 data:params,                            
					 }).then(res=> {
             console.log(res.data);
                      if(res.data!=0)
                       this.$notify({
                    title: '房东同意',
                     message: '你有'+res.data+'条房东同意租房消息'
        });
           })
           					this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/want/CheckDealNum',               
					 data:params,                            
					 }).then(res=> {
             console.log(res.data);
                      if(res.data!=0)
                       this.$notify({
                    title: '成交',
                     message: '你有'+res.data+'条成交消息'
        });
           })
                      					this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/transaction/CheckPayNum',               
					 data:params,                            
					 }).then(res=> {
                      if(res.data!=0)
                       this.$notify({
                    title: '待付款',
                     message: '你有'+res.data+'个待缴房款'
        });
           })
  },

      gethouse(){
        let params = new URLSearchParams();
                    params.append('user_id', this.$store.state.id);
					this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/house/SelectHouseByUserId',               
					 data:params,                            
					 }).then(res=> {
						this.pagination.totalRows=res.data.length;
						var tempData=[];
        for(var k=0;k<res.data.length;k++)
        {
          tempData.push(res.data[k]);
        }
        console.log(tempData);
        for(var k=0;k<tempData.length;k++)
        {
          var temp={
            house_id:tempData[k].house_id,
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

          this.totalData.push(temp);
        }
              this.pagination.pageNumber = 1;
      this.queryData();
        console.log(this.totalData);
					})
			
  },
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
        handleEdit(index, row,tableData) {
        console.log(index, row);

        this.editFormVisible = true;
        console.log(this.editFormVisible);

            this.editForm.ehouse_id=row.house_id;
            this.editForm.ecity_name=row.city_name;
            this.editForm.ecommunity_name=row.community_name;
            this.editForm.ehouse_num=row.house_num;
            this.editForm.ehouse_type=row.house_type;
            this.editForm.ehouse_area=row.house_area;
            this.editForm.ehouse_floor=row.house_floor;
            this.editForm.eis_elevator=row.is_elevator;
            this.editForm.edescription=row.description;
            this.editForm.edeposit=row.deposit;
            this.editForm.epayment_method=row.payment_method;
            this.editForm.erent_per_month=row.rent_per_month;
            this.editForm.modify_time=row.modify_time;
            this.editForm.estate=row.state;
            this.eindex=index;
                      if(this.editForm.ehouse_type=='一居')
          this.editForm.ehouse_type=1;
          if(this.editForm.ehouse_type=='二居')
          this.editForm.ehouse_type=2;
          if(this.editForm.ehouse_type=='三居')
          this.editForm.ehouse_type=3;
          if(this.editForm.ehouse_type=='四居+')
          this.editForm.ehouse_type=4;
          if(this.editForm.eis_elevator=='有')
          this.editForm.eis_elevator=1;
          if(this.editForm.eis_elevator=='无')
          this.editForm.eis_elevator=0;
          if(this.editForm.epayment_method=='月')
          this.editForm.epayment_method=1;
          if(this.editForm.epayment_method=='季')
          this.editForm.epayment_method=2;
          if(this.editForm.epayment_method=='年')
          this.editForm.epayment_method=3;
          if(this.editForm.estate=='已出租')
          this.editForm.estate=1;
          if(this.editForm.estate=='未出租')
          this.editForm.estate=0;

      },
      editSubmit(){
let params = new URLSearchParams();
				params.append('house_id', this.editForm.ehouse_id);
				params.append('city_name', this.editForm.ecity_name);
				params.append('community_name', this.editForm.ecommunity_name);
				params.append('house_num', this.editForm.ehouse_num);
				params.append('house_type', this.editForm.ehouse_type);
				params.append('house_area', this.editForm.ehouse_area);
        params.append('house_floor', this.editForm.ehouse_floor);
        params.append('is_elevator', this.editForm.eis_elevator);
        params.append('description', this.editForm.edescription);
        params.append('deposit', this.editForm.edeposit);
        params.append('payment_method', this.editForm.epayment_method);
				params.append('rent_per_month', this.editForm.erent_per_month);
				params.append('state', this.editForm.estate); 
					this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/house/UpdateHouse',               
					 data:params,                            
					 }).then(res=> {
						let resultjson=res.data;
						console.log(resultjson);
						if (resultjson!=0) {
              this.$message({message: '更新成功！',type: 'success'});
              this.editFormVisible=false;
							
              console.log('h'+this.eindex);
              this.tableData.splice(this.eindex, 1);
              var temp={
            house_id:this.editForm.ehouse_id,
            city_name:this.editForm.ecity_name,
            community_name:this.editForm.ecommunity_name,
            house_num:this.editForm.ehouse_num,
            house_type:this.editForm.ehouse_type,
            house_area:this.editForm.ehouse_area,
            house_floor:this.editForm.ehouse_floor,
            is_elevator:this.editForm.eis_elevator,
            description:this.editForm.edescription,
            deposit:this.editForm.edeposit,
            payment_method:this.editForm.epayment_method,
            rent_per_month:this.editForm.erent_per_month,
            modify_time:this.editForm.emodify_time,
            state:this.editForm.estate
          }
          temp.modify_time=resultjson;

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
              this.tableData.splice(this.eindex,0,temp);
						}else{
							//this.$message({message: '注册失败！',type: 'success'});
							this.$message.error('更新失败,网络异常！');
							//window.alert('注册失败,服务器错误,请重试！');
						}
					})
      },
      handleDelete(index, row,tableData) {
        console.log(index, row);
        console.log(tableData);
        let params = new URLSearchParams();
        params.append('house_id', row.house_id);
        this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/house/DeleteHouse',               
					 data:params,                            
					 }).then(res=> {
                         let resultjson=res.data;
						console.log(resultjson);
						if (resultjson==1) {
							this.$message({message: '删除成功',type: 'success'});
							 tableData.splice(index, 1);
        
							
						}else if(resultjson==0){
							
							this.$message.error('删除失败');
							
						}

      })
      },
      photo(row){
        this.$router.push({
                    path:"/showphoto",//跳转路由
                    query:{//参数对象
                        house_id:row.house_id,
                        type:1,
                    }

      })
      }
    },
        	mounted(){
      this.gethouse();
      this.getmessage();
		}
  }
  
</script>
