 function validation()
 {
var ProId    =  document.getElementById("proId").value;
var ProName   = document.getElementById("proName").value;
var ProPrice  = document.getElementById("proPrice").value;
var ProBrand   =  document.getElementById("proBrand").value;
var ProMadeIn  =  document.getElementById("proMadeIn").value;

if(ProId.trim()==="" ||ProName.trim()===""||ProPrice.trim()===""||ProBrand.trim()==="" || ProMadeIn.trim()==="")
   {
	alert("all fields must be fill");
    
 return false;
 }
 
 
 
if(parseFloat(ProPrice)<0)
     {
	 alert("proprice must be a non-negative values");
	 return false;
     }
 
 if(ProName.length>50||ProBrand.length>50)
     {
	 alert("ProName &ProBrand must have less 50 characters ");
	 return false;
     }
 
 // get the mgf and exp date
 
 var ProMfgDate=    document.getElementById("proMfgDate").value
  var ProExpDate=    document.getElementById("proExpDate").value
  
  // convert into date 
  var manufacturingobj = new date(ProMfgDate)
  var experingobj = new date(ProExpDate)
 
 if(manufacturingobj>experingobj)
 {
	 alert("manufacturing date can't be greater than expering date");
	return false;
 }
 
return true ;
}



 