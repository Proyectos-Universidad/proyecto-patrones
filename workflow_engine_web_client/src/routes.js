import Users from './containers/Users'
import Workflows from './containers/Workflows'
import FunctionalAreas from './containers/FunctionalAreas'

import UserIcon from "@material-ui/icons/Person";
import FunctionalAreaIcon from "@material-ui/icons/Assignment";
import WorkflowIcon from "@material-ui/icons/CompareArrows";

import CreateIcon from "@material-ui/icons/AddCircle";
import ReadIcon from "@material-ui/icons/List";
import UpdateIcon from "@material-ui/icons/Edit";
import DeleteIcon from "@material-ui/icons/Delete";

let routes = [
    {
        path: "/users",
        name: "Users",
        icon: UserIcon,
        component: Users
    },
    {
        path: "/functional-areas",
        name: "Functional areas",
        icon: FunctionalAreaIcon,
        component: FunctionalAreas
    },
    {
        path: "/workflows",
        name: "Workflows",
        icon: WorkflowIcon,
        component: Workflows
    },

    {
        path: "/create",
        name: "Create",
        icon: CreateIcon,
        component: Workflows
    },

    {
        path: "/update",
        name: "Update",
        icon: UpdateIcon,
        component: Workflows
    },

    {
        path: "/delete",
        name: "Delete",
        icon: DeleteIcon,
        component: Workflows
    },
    {
        path: "/read",
        name: "Read",
        icon: ReadIcon,
        component: Workflows
    }
];

export default routes;