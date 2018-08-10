import React from 'react'
import { Switch, Route } from 'react-router-dom'

// The Main component renders one of the three provided
// Routes (provided that one matches). Both the /roster
// and /schedule routes will match any pathname that starts
// with /roster or /schedule. The / route will only match
// when the pathname is exactly the string "/"
const Main = (props) => (
  <main>
    <Switch>
      {props.routes.map((r)=>{
        return(<Route exact key={r.path} path={r.path} component={r.component}/>);
      })}
    </Switch>
  </main>
)

export default Main;