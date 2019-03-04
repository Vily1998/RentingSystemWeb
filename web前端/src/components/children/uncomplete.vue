<template>
<html>
<el-row>
  <el-col :span="1">
      <div>
        <router-link to = "/myhouse"><el-button><i class="el-icon-caret-left"></i> </el-button></router-link>
      </div>
  </el-col>
  <el-col :span="21">
      <div>
          <h1>未支付订单</h1> 
      </div>
      <div>
        
        </div>
  </el-col>
</el-row>
<el-dialog
  title="确认付款"
  :visible.sync="dialogVisible"
  width="30%"
  :before-close="handleClose">
  <span>开始时间：{{payform.start_month}}月</span>
  <br>
  <span>租住时间：{{payform.continual_month}}月</span>
  <br>
  <span>月租金：{{payform.rent_per_month}}元</span>
  <br>
  <span>总租金：{{payform.total_rent}}元</span>
  <br>
    <span>押金：{{payform.deposit}}元</span>
  <br>
    <br>
    <span>中介费：{{payform.agency_fee}}元</span>
  <br>
  <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="paysubmit">确 定</el-button>
  </span>
</el-dialog>
		<el-dialog title="房屋信息" :visible.sync="editFormVisible" :close-on-click-modal="true" :label-position="right">

			<el-form :model="editForm" label-width="300px" :rules="editFormRules" ref="editForm">

				<el-form-item  label="城市" prop="name">

					<p >{{editForm.ecity_name}}</p>

				</el-form-item>

				<el-form-item label="街区">

					<p>{{editForm.ecommunity_name}}</p>

				</el-form-item>

				<el-form-item label="门牌号">

					<p>{{editForm.ehouse_num}}</p>

				</el-form-item>

				<el-form-item label="房型">

                <p>{{editForm.ehouse_type}}</p>

				</el-form-item>
        		<el-form-item label="面积" prop="name">

					<p>{{editForm.ehouse_area}}</p>

				</el-form-item>

				<el-form-item label="楼层">

                <p>{{editForm.ehouse_floor}}</p>
				</el-form-item>

				<el-form-item label="是否有电梯">

                <p>{{editForm.eis_elevator}}</p>

				</el-form-item>

				<el-form-item label="描述">

			    <p>{{editForm.edescription}}</p>

				</el-form-item>
        		<el-form-item label="押金" prop="name">

				<p>{{editForm.edeposit}}</p>

				</el-form-item>

				<el-form-item label="支付方式">

                <p>{{editForm.epayment_method}}</p>

				</el-form-item>

				<el-form-item label="月租金">

				<p>{{editForm.edeposit}}</p>

				</el-form-item>

			</el-form>

			<div slot="footer" class="dialog-footer">

				<el-button @click.native="editFormVisible = false">关闭</el-button>

			</div>

		</el-dialog>

      <el-table
    :data="tableData"
    border
    style="width: 100%">
        <el-table-column
      prop="start_month"
      label="开始月份"
      sortable
      width="120">
    </el-table-column>
    <el-table-column
      prop="continual_month"
      label="租住月数"
      sortable
      width="120">
    </el-table-column>
        <el-table-column
      prop="description"
      label="描述"
      width="400">
    </el-table-column>
      <el-table-column
      prop="modify_time"
      label="时间"
      sortable
      width="120">
    </el-table-column>
        <el-table-column
      label="房屋信息"
      width="120">
      <template slot-scope="scope">
        <el-button
          size="mini"
          type="success"
          @click.native.prevent="look(scope.$index, scope.row,tableData)">查看</el-button>
      </template>
    </el-table-column>

    <el-table-column
      label="操作"
      width="120">
      <template slot-scope="scope">
        <el-button
          size="mini"
          type="success"
          @click.native.prevent="pay(scope.$index, scope.row,tableData)">支付</el-button>
      </template>
    </el-table-column>
  </el-table>


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
</style>
<script>
  export default {
   data() {
      return {
        tableData:[],
        dialogVisible:false,

        payform:{
          want_id:0,
        start_month:0,
        continual_month:0,
        rent_per_month:0,
        total_rent:0,
        deposit:0,
        agency_fee:0,
        },
				editForm: {
          erent_id:0,
            ecity_name:'',
            ecommunity_name:'',
            ehouse_type:0,
            ehouse_floor:0,
            eis_elevator:0,
            edescription:'',
            edeposit:0,
            epayment_method:0,
            erent_per_month:0,
            emodify_time:'',

        },
        editFormVisible:false,
        eindex:0,
        eindex2:0
      }
    },
    methods: {
    getwant(){
          let params = new URLSearchParams();
          params.append('user_id', this.$store.state.id);
					this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/want/SelectWantByTenantUserId',               
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
        want_id:res.data[k].want_id,
        landlord_user_id:res.data[k].landlord_user_id,
        house_id:res.data[k].house_id,
        tenant_user_id:res.data[k].tenant_user_id,
         real_name:res.data[k].real_name,
        start_month:res.data[k].start_month,
        continual_month:res.data[k].continual_month,
         description:res.data[k].description,
         modify_time:res.data[k].modify_time,
         state:res.data[k].state,
          }
          console.log(temp)
          if(temp.state==2)
          this.tableData.push(temp);
        }
        console.log(this.tableData);
					})
			
  },
  look(index, row,tableData) {
        console.log(index, row);

        this.editFormVisible = true;
        console.log(this.editFormVisible);
        let params = new URLSearchParams();
				params.append('house_id', row.house_id);
					this.$axios({                
						method:"post",                           
			  		url:'http://localhost:8080/RentHouseSystem/house/SelectHouseByHouseId',               
					 data:params,                            
					 }).then(res=> {
						let resultjson=res.data;
						console.log(resultjson);
            this.editForm.ehouse_id=resultjson.house_id;
            this.editForm.ecity_name=resultjson.city_name;
            this.editForm.ecommunity_name=resultjson.community_name;
            this.editForm.ehouse_num=resultjson.house_num;
            this.editForm.ehouse_type=resultjson.house_type;
            this.editForm.ehouse_area=resultjson.house_area;
            this.editForm.ehouse_floor=resultjson.house_floor;
            this.editForm.eis_elevator=resultjson.is_elevator;
            this.editForm.edescription=resultjson.description;
            this.editForm.edeposit=resultjson.deposit;
            this.editForm.epayment_method=resultjson.payment_method;
            this.editForm.erent_per_month=resultjson.rent_per_month;
            this.editForm.modify_time=resultjson.modify_time;
            this.editForm.estate=resultjson.state;
            this.eindex=index;
          if(this.editForm.ehouse_type==1)
          this.editForm.ehouse_type='一居';
          if(this.editForm.ehouse_type==2)
          this.editForm.ehouse_type='二居';
          if(this.editForm.ehouse_type==3)
          this.editForm.ehouse_type='三居';
          if(this.editForm.ehouse_type==4)
          this.editForm.ehouse_type='四居+';
          if(this.editForm.eis_elevator==1)
          this.editForm.eis_elevator='有';
          if(this.editForm.eis_elevator==0)
          this.editForm.eis_elevator='无';
          if(this.editForm.epayment_method==1)
          this.editForm.epayment_method='月';
          if(this.editForm.epayment_method==2)
          this.editForm.epayment_method='季';
          if(this.editForm.epayment_method==3)
          this.editForm.epayment_method='年';
          if(this.editForm.estate==1)
          this.editForm.estate='已出租';
          if(this.editForm.estate==0)
          this.editForm.estate='未出租';
        
        console.log(this.tableData);
					
            
           })
      },
      pay(index, row,tableData){
      this.dialogVisible=true;
      this.payform.start_month=row.start_month;
      this.payform.continual_month=row.continual_month;
      this.payform.want_id=row.want_id;
      this.eindex2=index;
       let params = new URLSearchParams();
				params.append('house_id', row.house_id);
					this.$axios({                
						method:"post",                           
			  		url:'http://localhost:8080/RentHouseSystem/house/SelectHouseByHouseId',               
					 data:params,                            
					 }).then(res=> {
						let resultjson=res.data;
            this.payform.rent_per_month=resultjson.rent_per_month;
            this.payform.total_rent=this.payform.rent_per_month*this.payform.continual_month;
            this.payform.deposit=resultjson.deposit;
            this.salename = this.$store.state.account;
			
          let params2 = new URLSearchParams();
          params2.append('user_name', this.salename);

          	this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/user/UserInformation',               
					 data:params2,                            
					 }).then(res=> {
             
              let t=res.data.user_level;
                console.log(t);
              if(t==0) this.payform.agency_fee=this.payform.total_rent*0.1;
	             else if(t==1) this.payform.agency_fee=this.payform.total_rent*0.05;
	             else this.payform.agency_fee=this.payform.total_rent*0.01;

           })
           })

      },
      paysubmit(){
        this.dialogVisible=false;
          console.log(1);
           let params = new URLSearchParams();
				params.append('want_id', this.payform.want_id);
					this.$axios({                
						method:"post",                           
			  		url:'http://localhost:8080/RentHouseSystem/transaction/Agree2Deal',               
					 data:params,                            
					 }).then(res=> {
              if(res.data!=0)
              {
              this.$message({message: '交易成功！',type: 'success'});
              this.tableData.splice(this.eindex2, 1);
              }
              else
              {
              this.$message({message: '网络忙！',type: 'error'});
              }
        
      })
      },
        handleEdit(index, row,tableData) {
        console.log(index, row);

        this.editFormVisible = true;
        console.log(this.editFormVisible);

            this.editForm.erent_id=row.rent_id;
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
          if(this.editForm.ehouse_floor=='任意')
          this.editForm.ehouse_floor=-1;
          if(this.editForm.edeposit=='任意')
          this.editForm.edeposit=-1;
          if(this.editForm.erent_per_month=='任意')
          this.editForm.erent_per_month=-1;
          if(this.editForm.ehouse_type=='任意')
          this.editForm.ehouse_type=-1;
          if(this.editForm.eis_elevator=='任意')
          this.editForm.eis_elevator=-1;
          if(this.editForm.epayment_method=='任意')
          this.editForm.epayment_method=-1;
      },
      editSubmit(){
let params = new URLSearchParams();
				params.append('rent_id', this.editForm.erent_id);
				params.append('city_name', this.editForm.ecity_name);
				params.append('community_name', this.editForm.ecommunity_name);
				params.append('house_type', this.editForm.ehouse_type);
        params.append('house_floor', this.editForm.ehouse_floor);
        params.append('is_elevator', this.editForm.eis_elevator);
        params.append('description', this.editForm.edescription);
        params.append('deposit', this.editForm.edeposit);
        params.append('payment_method', this.editForm.epayment_method);
				params.append('rent_per_month', this.editForm.erent_per_month);
					this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/rent/UpdateRent',               
					 data:params,                            
					 }).then(res=> {
						let resultjson=res.data;
						console.log(resultjson);
						if (resultjson.code!=0) {
              this.$message({message: '更新成功！',type: 'success'});
              this.editFormVisible=false;
							//window.alert('注册成功,赶快登陆吧！');
              console.log('h'+this.eindex);
              this.tableData.splice(this.eindex, 1);
              var temp={
            rent:this.editForm.erent_id,
            city_name:this.editForm.ecity_name,
            community_name:this.editForm.ecommunity_name,
            house_type:this.editForm.ehouse_type,
            house_floor:this.editForm.ehouse_floor,
            is_elevator:this.editForm.eis_elevator,
            description:this.editForm.edescription,
            deposit:this.editForm.edeposit,
            payment_method:this.editForm.epayment_method,
            rent_per_month:this.editForm.erent_per_month,
            modify_time:this.editForm.emodify_time,
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
          if(temp.state==1)
          temp.state='已出租';
          if(temp.state==0)
          temp.state='未出租';
          if(temp.house_floor==-1)
          temp.house_floor='任意';
          if(temp.deposit==-1)
          temp.deposit='任意';
          if(temp.rent_per_month==-1)
          temp.rent_per_month='任意';
          if(temp.house_type==-1)
          temp.house_type='任意';
          if(temp.is_elevator==-1)
          temp.is_elevator='任意';
          if(temp.payment_method==-1)
          temp.payment_method='任意';
              this.tableData.push(temp);
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
        params.append('rent_id', row.rent_id);
        this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/rent/DeleteRent',               
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
      }
    },
        	mounted(){
			this.getwant()
		}
  }
</script>