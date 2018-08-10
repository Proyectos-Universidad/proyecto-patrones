import React from 'react'
import CrudTable from '../components/CrudTable';

class Users extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      users: []
    };
  }

  componentDidMount() {
    fetch('api/users/')
      .then(res => {
        return res.json();
      })
      .then(j => {
        this.setState({ users: j });
        console.log(j);
      });
  }

  render() {
    return (
      <CrudTable data={this.state.users} 
      columns={{
        email:{
          name:'Email'
        },
        name:{
          name:'Name'
        },
        lastName:{
          name:'Last name'
        },
        admin:{
          name:'Is admin',
          process:(a)=>(a ? 'Yes' : 'No')
        }
      }}/>
    );
  }
}
export default Users;