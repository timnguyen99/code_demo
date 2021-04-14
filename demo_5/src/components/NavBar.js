import React, { Component } from 'react';
import { Link } from 'react-router-dom';

import './NavBar.css';

export default class NavBar extends Component {
render(){
  return (
    <div className= "NavBar">
      
      <Link to="/">HOME</Link>
      <ul>
        <button><Link to="/Registration">Registration</Link></button>
        
     	</ul>
      <hr />
    </div>
  );
};
}