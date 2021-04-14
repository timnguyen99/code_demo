import React from 'react';
import './registration.css'

export default class Registration extends React.Component{
    constructor(props){
      super(props);

      this.state = {
        fields: {},
        errors: {},
        
      }
    }
    
    checkCharacters(){
      let fields = this.state.fields;
      let errors = {};
      let formIsValid = true;


      if(!fields["firstname"]){
         formIsValid = false;
         errors["firstname"] = "Cannot be empty";
      }
      if(!fields["lastname"]){
        formIsValid = false;
        errors["lastname"] = "Cannot be empty";
     }

      if(typeof fields["firstname"] !== "undefined"){
         if(!fields["firstname"].match(/^[a-zA-Z]+$/)){
            formIsValid = false;
            errors["firstname"] = "Please input characters from A-Z only";
         }        
      }
      if(typeof fields["lastname"] !== "undefined"){
        if(!fields["lastname"].match(/^[a-zA-Z]+$/)){
           formIsValid = false;
           errors["lastname"] = "Please input characters from A-Z only";
        }        
     }
 
      if(!fields["email"]){
         formIsValid = false;
         errors["email"] = "Cannot be empty";
      }

      if(typeof fields["email"] !== "undefined"){
         let lastAtPos = fields["email"].lastIndexOf('@');
         let lastDotPos = fields["email"].lastIndexOf('.');

         if (!(lastAtPos < lastDotPos && lastAtPos > 0 && fields["email"].indexOf('@@') == -1 && lastDotPos > 2 && (fields["email"].length - lastDotPos) > 2)) {
            formIsValid = false;
            errors["email"] = "Email is not valid";
          }
     }  
     if(typeof fields["NPI"] !== "undefined"){
      if(!fields["NPI"].match(/^[0-9\b]+$/)){
         formIsValid = false;
         errors["NPI"] = "Please input numbers";
      }        
   }
   if(!fields["NPI"]){
    formIsValid = false;
    errors["NPI"] = "Cannot be empty";
 }
   if(typeof fields["phone"] !== "undefined"){
    if(!fields["phone"].match(/^(\+\d{1,2}\s)?\(?\d{3}\)?[\s.-]\d{3}[\s.-]\d{4}$/)){
       formIsValid = false;
       errors["phone"] = "Please input numbers";
    }        
 }
 if(!fields["phone"]){
  formIsValid = false;
  errors["phone"] = "Cannot be empty";
}
   

     this.setState({errors: errors});
     return formIsValid;
 }
  
 onSubmit(e){
      e.preventDefault();

      if(this.checkCharacters()){
         alert("Form submitted sucessfully");
      }else{
         alert("Form not submmitted. Please check error(s)")
      }

  }

  handleChange(field, e){         
      let fields = this.state.fields;
      fields[field] = e.target.value;        
      this.setState({fields});
  }
   
      render() {
        return (
          <form name="contactform" onSubmit= {this.onSubmit.bind(this)}>
              <table>
              <tbody>
                  <tr>
                    <td >First Name</td>
                    <td>
                        <input  type="text" placeholder="First Name" onChange={this.handleChange.bind(this, "firstname")} value={this.state.fields["firstname"]}/>
                        <span className="error">{this.state.errors["firstname"]}</span>
                    </td>
               
                  </tr>
                  <tr>
                    <td >Last Name </td>
                    <td>
                        <input  type="text" placeholder="Last Name" onChange={this.handleChange.bind(this, "lastname")} value={this.state.fields["lastname"]} />
                        <span className="error">{this.state.errors["lastname"]}</span>
                    </td>
                  </tr>
                  <tr>
                    <td >NPI number </td>
                    <td>
                        <input  refs="NPI" type="text" size="30" placeholder="NPI" onChange={this.handleChange.bind(this, "NPI")} value={this.state.fields["NPI"]} />
                        <span className="error">{this.state.errors["NPI"]}</span>
                    </td>
                  </tr>
                  <tr>
                    <td >Business Address </td>
                    <td>
                        <textarea refs="address" type="text" size="30" placeholder="Address" onChange={this.handleChange.bind(this, "address")} value={this.state.fields["address"]}/>
                        <span className="error">{this.state.errors["firstname"]}</span>
                    </td>
                  </tr>
                  <tr>
                    <td >Telephone Number </td>
                    <td>
                        <input refs="phone" type="text" size="30" placeholder="Phone" onChange={this.handleChange.bind(this, "phone")} value={this.state.fields["phone"]}/>
                        <span className="error">{this.state.errors["phone"]}</span>
                    </td>
                  </tr>
                  <tr>
                    <td >Email address </td>
                    <td>
                        <input refs="email" type="text"  placeholder="Email" onChange={this.handleChange.bind(this, "email")} value={this.state.fields["email"]}/>        
                        <span className="error">{this.state.errors["email"]}</span>                 
                    </td>
                  </tr>
              </tbody>
              </table>
            <br />
            <button  >Submit</button>
          </form>
        );
      }
}