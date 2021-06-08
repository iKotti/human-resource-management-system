import "./App.css";
import "semantic-ui-css/semantic.min.css";
import Navbar from "./layout/Navbar";
import HomeDashboard from "./layout/HomeDashboard";
import Footer from "./layout/Footer";
import Login from "./pages/Login";

function App() {
  return (
    <div className="App">

      <Navbar/>
      {/* <Login/> */}
      <HomeDashboard/>
      <Footer/>
    </div>
  );
}

export default App;
