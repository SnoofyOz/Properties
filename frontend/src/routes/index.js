import HomePage from "../pages/HomePage/Home.jsx";
import User from "../pages/AdminPage/User/User.jsx";
import UserDetail from "../pages/AdminPage/User/UserDetail.jsx";
import SignInPage from "../pages/SignInPage/SignInPage.jsx";
import SignUpPage from "../pages/SignUpPage/SignUpPage.jsx";
import AdminPage from "../pages/AdminPage/AdminPage.jsx";
import UserInfoPage from "../pages/UserInfoPage/UserInfoPage.jsx";
import Portal1 from "../pages/PortalPage/Portal1.jsx";
import Portal2 from "../pages/PortalPage/Portal2.jsx";
import Portal3 from "../pages/PortalPage/Portal3.jsx";

export const routes = [
    {
        path: '/',
        page: HomePage,
        isShowHeader: true
    },
    {
        path: 'admin/users',
        page: User,
        isShowHeader: true
    },
    {
        path: '/login',
        page: SignInPage,
        isShowHeader: true
    },
    {
        path: '/register',
        page: SignUpPage,
        isShowHeader: true
    },
    {
        path: '/admin',
        page: AdminPage,
        isShowHeader: true
    },
    {
        path: '/portal1',
        page: Portal1,
        isShowHeader: true
    },
    {
        path: '/portal2',
        page: Portal2,
        isShowHeader: true
    },
    {
        path: '/portal3',
        page: Portal3,
        isShowHeader: true
    },
        {
        path: '/users/:username',
        page: UserInfoPage,
        isShowHeader: true
    },
    {
        path: '/admin/user/:id',
        page: UserDetail,
        isShowHeader: true
    }
]