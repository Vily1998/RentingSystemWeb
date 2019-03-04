<template>
<html>
<div>
          <el-menu
            :default-active="activeIndex2"
            class="el-menu-demo"
            mode="horizontal"
            @select="handleSelect"
            background-color="#00B8EC"
            text-color="#fff"
            active-text-color="#ffd04b">
            <el-menu-item index="1" @click="changelink(url)">返回</el-menu-item>
          </el-menu>
</div>
    <div class="info" style="text-align: center;">
      <h1><el-card class="grid-content bg-purple-light" >为你的房屋添加照片吧</el-card></h1>
      

  
      <el-upload
  class="upload-demo"
  ref="upload"
  list-type="picture-card"
  :on-preview="handlePictureCardPreview"
  :file-list="fileList"
  :before-upload="handlePicture"
  :before-remove="handleRemove"
  >
  <i class="el-icon-plus"></i>
</el-upload>
                <el-dialog v-model="dialogVisible" size="tiny">
        <img width="100%" :src="dialogImageUrl" alt="">
      </el-dialog>
      
    </div>

				
				
  </html>
  </template>
  <script>
  export default {
    data () {
      return {
        img_list:[],
        id:0,
        dialogImageUrl:'',
        dialogVisible: false,
        fileList:[],
        visible:true,
        type:0,
      }
    },
    methods: {
      up(){
        this.visible=true;
      },
        submitUpload() {
        this.$refs.upload.submit();
      },
              changelink(route){
    this.$router.replace(route);
  },
         getParams () {
this.id = this.$router.history.current.query.house_id;
this.type = this.$router.history.current.query.type;
if(this.type==1)
this.url="/myhouse";
else
this.url="/Calendar"
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
                         console.log(this.img_List);
                         for(var k=0;k<res.data.length;k++)
                        {   var temp={
                                        name:'pic'+k,
                                        url:res.data[k].photo,
                                      }
                            this.fileList.push(temp);
                         }
                         console.log(this.fileList);

                     })
      },
      handleRemove(file, fileList) {

          console.log(file,this.fileList);
          let params = new URLSearchParams();
        params.append('photo', file.url);
            this.$axios({                
						method:"post",                           
					url:'http://localhost:8080/RentHouseSystem/house/DeletePhoto',               
                     data:params,           
					 }).then(res => {
                        if(res.data!=null)
                        {
                         this.$message({message: '删除成功！',type: 'success'});
                          var i = this.fileList.length;
                          console.log(i);
                          while (i--) {
                          if (this.fileList[i] === file) {
                            console.log(i);
                          this.fileList.splice(i,1);
                            }
                            console.log(this.fileList);
                         }  
                        }
                        else
                        {
                        return false;
                        }
              })
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
                        if(res.data)
                        {
                          
                          var k=Math.ceil(Math.random()*10000);
                                       var temp={
                                        name:'pic'+k,
                                        url:res.data,
                                      }
                            this.fileList.push(temp);
                            console.log(this.fileList);
                            this.$message({message: '添加成功！',type: 'success'});
                        }
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
        #app .img-list {
        margin-top:20px;
      }

      #app .img-list img {
        float: left;
        width: 90px;
        height:90px;
        margin:8px;
        display: block;
        border:1px solid #e0e0e0;
        border-radius: 3px;
      }
  </style>
  