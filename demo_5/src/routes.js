import React, { Component } from 'react';
import Home from './components/Home';
import  Registration  from './components/registration';

import NavBar from "./components/NavBar.js";
import { Route, Switch} from 'react-router-dom';

export default class Routes extends Component {
    render(){
  return (
    
    <React.Fragment>
      <NavBar />
      <Switch>
        
      <Route exact path="/" component={Home} />
      <Route exact path="/Registration" component={Registration} />
        
      </Switch>
    </React.Fragment>
  );
};}