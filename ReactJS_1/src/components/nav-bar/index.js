import React from "react";
import "./index.css";

export default function NavBar(props) {

  return (
    <div className="layout-column justify-content-center align-items-center">
      <div className="layout-row justify-content-around align-items-center mt-20 links"
           data-testid="navigation-tabs">
          <a onClick={()=>{props.setPage("HOME") }}>Home</a>
          <a onClick={()=>{props.setPage("NEWS") }}>News</a>
          <a onClick={()=>{props.setPage("CONTACT")}}>Contact</a>
          <a onClick={()=>{props.setPage("ABOUT") }}>About</a>
      </div>

      <div className="card w-20 ma-0">
        <section className="card-text" data-testid="tab-content">
           <span>{props.page} PAGE</span>      
        </section>
      </div>
    </div>
  );
}