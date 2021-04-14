import React, {Component} from 'react';
import './App.css';
import NavBar from './components/nav-bar/index.js';
import 'h8k-components';

const title = "Navigation Bar";

export const page='';

class App extends Component {
  constructor() {
      super();   
      this.page='HOME'
      this.state = {
        page
      }
      this.setPage = this.setPage.bind(this);
  }

  setPage(page){
    this.page = page;

    this.setState({
      page
    });
  }

  render() {
    return (
      <div>
        <h8k-navbar header={title} />
        <NavBar setPage={this.setPage} page={this.page}/>
      </div>
    );
  }
}

export default App;
