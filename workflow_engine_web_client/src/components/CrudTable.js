import React from 'react';
import { withStyles } from '@material-ui/core/styles';
import Grid from '@material-ui/core/Grid';
import Typography from '@material-ui/core/Typography';
import CreateIcon from "@material-ui/icons/AddCircle";
import Table from './Table';
import IconCard from './IconCard';

const styles = theme => ({
  root: {
    flexGrow: 1,
    padding: theme.spacing.unit * 2,
  },
  paper: {
    padding: theme.spacing.unit * 2,
    textAlign: 'center',
    color: theme.palette.text.secondary,
  },
});

function CrudTable(props) {
  const { classes, data, columns } = props;

  return (
    <div className={classes.root}>
      <Grid container spacing={24}>
        <Grid item xs={12}>
          <Typography variant='headline'>
              Users
          </Typography>
        </Grid>
        <Grid item xs={3}>
        </Grid>
        <Grid item xs={12}>
          <Table data={data} columns={columns}/>
        </Grid>
      </Grid>
    </div>
  );
}

export default withStyles(styles)(CrudTable);