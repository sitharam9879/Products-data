<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="Product.js">
	  
  </script>
</head>

<body>
	<div class="container mt-5 text-center">
     <h2 class="text-center font-italic mb-1">  Edit  Form </h2>
      <form method="post" action="./UpdateProductServlet" enctype="multipart/form-data" onsubmit=" return validation()">
	
	<div class ="form-group">
	    <label class="font-italic font-weight-bold" for="ProId">Product Id:</label>
	     <input type="text" class="form-control-sm" id="ProId" name="proId" value="${product.proId}" required/>
	      </div>
	      
<div class ="form-group">
	    <label class="font-italic font-weight-bold" for="ProName">Product Name:</label>
	     <input type="text" class="form-control-sm" id="ProName" name="proName" value="${product.proName}"  required/>
	      </div>
	
	
	<div class ="form-group">
	    <label class="font-italic font-weight-bold" for="ProPrice">Product Price:</label>
	     <input type="text" class="form-control-sm" id="ProPrice" name="proPrice" value="${product.proPrice}" required/>
	      </div>
	
	
	<div class ="form-group">
	        <label class="font-italic font-weight-bold" for="ProBrand"> Brand:</label>
	        <input type="text" class="form-control-sm" id="ProBrand" name="proBrand" value="${product.proBrand}"  required/>
	           </div>
	
	 <div class ="form-group">
	        <label class="font-italic font-weight-bold" for="ProMadeIn">product MadeIn:</label>
	        <input type="text" class="form-control-sm" id="ProMadeIn" name="proMadeIn"  value="${product.proMadeIn}" required/>
	          </div>
	   
	   
	<div class ="form-group">
	        <label class="font-italic font-weight-bold" for="ProMfgDate">Manufature Date:</label>
	        <input type="date" class="form-control-sm" id="ProMfgDate" name="proMfgDate" value="${product.proMfgDate}"  required/>
	           </div>
	
	<div class ="form-group">
	        <label class="font-italic font-weight-bold" for="ProExpDate">expiry Date:</label>
	        <input type="date" class="form-control-sm" id="ProExpDate" name="proExpDate" value="${product.proExpDate}"  required/>
	           </div>
	
	<div class ="form-group">
	        <label class="font-italic font-weight-bold" for="ProImage">product Image:</label>
	        <input type="file" class="form-control-file-sm" id="ProImage" name="proImage"  value="${product.proImage}" accept="image/*" />
	          </div>
	 <div>
		<input type="submit" class="btn btn-success" value=" Update Product"/>
		<a href="ProductList.jsp" class="btn btn-primary">List of products</a>
	      </div>
         </form>	
	   </div>

       </body>
</html>