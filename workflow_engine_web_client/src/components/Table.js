import React from 'react';
import { withStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';

const styles = theme => ({
  root: {
    width: '100%',
    marginTop: theme.spacing.unit * 3,
    overflowX: 'auto',
  },
  table: {
    minWidth: 700,
  },
});

function SimpleTable(props) {
  const { classes, columns, data } = props;
  const tableSpec = Object.getOwnPropertyNames(columns);

  return (
    <Paper className={classes.root}>
      <Table className={classes.table}>
        <TableHead>
          <TableRow>
            {
              tableSpec.map(c => {
                return <TableCell key={columns[c].name}>{columns[c].name}</TableCell>;
              })
            }
          </TableRow>
        </TableHead>
        <TableBody>
          {data.map(d => {
            return (
              <TableRow key={d.id}>
                {
                  tableSpec.map(c => {
                    let colName
                    return <TableCell key={c +'-'+ d[c]}>{columns[c].process ? columns[c].process(d[c]): d[c]}</TableCell>;
                  })
                }
              </TableRow>
            );
          })}
        </TableBody>
      </Table>
    </Paper>
  );
}

export default withStyles(styles)(SimpleTable);