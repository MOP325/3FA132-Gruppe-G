import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import "./App.css";
import { DashboardPage } from "./DashboardPage";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<DashboardPage />} />
      </Routes>
    </Router>
  );
}

export default App;
