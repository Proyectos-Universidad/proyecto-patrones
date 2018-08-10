import React from "react";
import { withStyles } from "@material-ui/core/styles";
import Drawer from "@material-ui/core/Drawer";
import MenuList from "@material-ui/core/MenuList";
import MenuItem from "@material-ui/core/MenuItem";
import Hidden from "@material-ui/core/Hidden";
import Divider from "@material-ui/core/Divider";
import ListItemIcon from "@material-ui/core/ListItemIcon";
import ListItemText from "@material-ui/core/ListItemText";
import Typography from "@material-ui/core/Typography";
import IconButton from '@material-ui/core/IconButton';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import MenuIcon from '@material-ui/icons/Menu';
import Main from './Main';
import {Link, withRouter} from 'react-router-dom';




const drawerWidth = 240;
const logoTitle = "WORKFLOW ENGINE";

const styles = theme => ({
    root: {
        flexGrow: 1,
        zIndex: 1,
        overflow: "hidden",
        display: "flex",
        width: "100%",
    },
    navMarg: {
        marginLeft: drawerWidth
    },
    drawerPaper: {
        width: drawerWidth,
        [theme.breakpoints.up("md")]: {
            position: "fixed"
        }
    },
    logoContainer: {
        padding: 20
    },
    logo: {
        fontSize: 18,
        textAlign: "center",
        fontFamily: ["Roboto", "Helvetica", "Arial", "sans-serif"],
        textTransform: "uppercase",
        textDecoration: "none",
        backgroundColor: "transparent"
    },
    content: {
        width:"100%",
        [theme.breakpoints.down("sm")]: {
            paddingTop: theme.spacing.unit * 8,
        }
      }
});

class Sidebar extends React.Component {
    state = {
        mobileOpen: false
    };

    handleDrawerToggle = () => {
        this.setState(state => ({ mobileOpen: !state.mobileOpen }));
    };

    render() {
        const { classes, theme, location:{ pathname }, routes} = this.props;
        const brand = (
            <div className={classes.logoContainer}>
                <Typography variant="title" className={classes.logo}>
                    {logoTitle}
                </Typography>
            </div>
        );

        const drawer = (
            <div>
                {brand}
                <Divider />
                <MenuList>
                    {routes.map((r)=>{
                        return(
                        <MenuItem key={r.path} component={Link} to={r.path} selected={pathname === r.path}>
                            <ListItemIcon>
                               {React.createElement(r.icon,{}, null)}
                            </ListItemIcon>
                            <ListItemText primary={r.name} />
                        </MenuItem>
                        );
                    })}
                </MenuList>
            </div>
        );

        return (
            <div className={classes.root}>
                <Hidden mdUp>
                    <AppBar>
                        <Toolbar>
                            <IconButton
                                color="inherit"
                                aria-label="Open drawer"
                                onClick={this.handleDrawerToggle}
                            >
                                <MenuIcon />
                            </IconButton>
                            <Typography variant="title" color="inherit" noWrap>
                                {logoTitle}
                            </Typography>
                        </Toolbar>
                    </AppBar>
                    <Drawer
                        variant="temporary"
                        anchor={theme.direction === "rtl" ? "right" : "left"}
                        open={this.state.mobileOpen}
                        onClose={this.handleDrawerToggle}
                        classes={{
                            paper: classes.drawerPaper
                        }}
                        ModalProps={{
                            keepMounted: true // Better open performance on mobile.
                        }}
                    >
                        {drawer}
                    </Drawer>
                </Hidden>
                <Hidden smDown implementation="css">
                    <Drawer
                        variant="permanent"
                        open
                        classes={{
                            paper: classes.drawerPaper
                        }}
                    >
                        {drawer}
                    </Drawer>
                    <div className={classes.navMarg}></div>
                </Hidden>
                <div className={classes.content}>
                    <Main routes={routes}/>
                </div>
            </div>
        );
    }
}
export default withRouter(withStyles(styles, { withTheme: true })(Sidebar));
