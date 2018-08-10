import React from 'react';
import { withStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import {Link} from 'react-router-dom';
import Typography from '@material-ui/core/Typography';

const styles = {
  card: {
    textAlign: 'center',
    '&:hover':{
      boxShadow: '2px 2px 1px rgba(0,0,0,0.4)'
    } 
  },
  bullet: {
    display: 'inline-block',
    margin: '0 2px',
    transform: 'scale(0.8)',
  },
  title: {
    marginBottom: 16,
    fontSize: 24,
  },

  link: {
    textDecoration: 'none', 
    color: 'unset'
  },
};

function IconCard(props) {
  const { classes, icon, title, color, path } = props;
  const bull = <span className={classes.bullet}>•</span>;

  return (
    <div>
      <Link to={path} className={classes.link}>
        <Card className={classes.card}>
          <CardContent>
            <Typography className={classes.title} color="textSecondary">
              {title}
            </Typography>
            {React.createElement(icon,{style:{ fontSize: 85, color: color} }, null)}
          </CardContent>
        </Card>
      </Link>
    </div>
  );
}

export default withStyles(styles)(IconCard);