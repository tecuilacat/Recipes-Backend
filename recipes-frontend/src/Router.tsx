import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom"
import { Dashboard } from "./dashboard/Dashboard"

export const Router = () => {

    return <BrowserRouter>
        <Routes>
            <Route path="" element={<Navigate to={'dashboard'} />} />
            <Route path="dashboard" element={<Dashboard />} />
        </Routes>
    </BrowserRouter>

}