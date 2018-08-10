import React, { Component,Fragment } from 'react';
import CssBaseline from '@material-ui/core/CssBaseline';
import Sidebar from './components/Sidebar';
import Routes from './routes';

class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
      contacts: []
    };
  }

  componentDidMount() {
    /*fetch('api/users/')
      .then(res => {
        return res.json();
      })
      .then(j => {
        this.setState({ contacts: j });
      });*/
  }

  render() {
    return (
      <Fragment>
        <CssBaseline />
        <Sidebar routes={Routes}/>
      </Fragment>
    );
  }
}

export default App;

/*
render() {
    return (
      <Paper>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell>Name</TableCell>
              <TableCell numeric>Last name</TableCell>
              <TableCell numeric>Email</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {this.state.contacts.map(n => {
              return (
                <TableRow key={n.id}>
                  <TableCell component="th" scope="row">
                    {n.name}
                  </TableCell>
                  <TableCell numeric>{n.lastName}</TableCell>
                  <TableCell numeric>{n.email}</TableCell>
                </TableRow>
              );
            })}
          </TableBody>
        </Table>
      </Paper>
    );
  }
}
*/