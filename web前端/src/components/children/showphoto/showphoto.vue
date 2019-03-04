<template>
<html>
<div>
<router-link to = "/house_manage"><el-button><i class="el-icon-caret-left"></i> </el-button></router-link>
</div>
    <div class="info" style="text-align: center;">
      <h1><el-card class="grid-content bg-purple-light" >为你的房屋添加照片吧</el-card></h1>
      
      <el-upload

  list-type="picture-card"
  :on-preview="handlePreview"
  :on-remove="handleRemove"
  :file-list="fileList"
  :before-upload="handlePicture"
  :auto-upload="false">
  <i class="el-icon-plus"></i>
</el-upload>
<el-dialog :visible.sync="dialogVisible">
  <img width="100%" :src="dialogImageUrl" alt="">
</el-dialog>
    </div>

				
				
  </html>
  </template>
  <script>
  export default {
    data () {
      return {
        id:0,
        dialogImageUrl:'',
        dialogVisible: false,
        fileList:[],
      }
    },
    methods: {
        submitUpload() {
        this.$refs.upload.submit();
      },

         getParams () {
this.id = this.$router.history.current.query.house_id;
console.log(this.id);

      },
      getphoto(){
         let params = new URLSearchParams();
         params.append("house_id",this.id);
         this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/house/download',               
					 data:params,                            
					 }).then(res=> {
                         
                         for(var k=0;k<res.data.length;k++)
                        {
                            this.fileList.push(res.data[k]);
                         }
                         console.log(this.fileList);

                     })
      },
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePictureCardPreview(file) {
        this.dialogImageUrl = file.url;
        this.dialogVisible = true;
      },
      handlePicture(file){
           console.log(1);
          let formdata = new FormData();
          console.log(this.id);
          formdata.append('house_id',this.id);
          formdata.append('file',file);
          let config = {            
            headers: {'Content-Type': 'multipart/form-data'}
            };

          
                   this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/house/upload',               
                     data:formdata,             
              config:config,
					 }).then(res => {
                        if(res.data==1)
                        	this.$message({message: '添加成功！',type: 'success'});
                        else
                        return false;
              })  
      },
    
    },
    	mounted(){
            this.getParams();
            this.getphoto();
        }
        
  }
  </script>
  
  <style lang="less" scoped>
  @import '../../less/index.less';
 #logon{
	position : absolute;
	left:750px;
  top:500px;
  }
  </style>
  