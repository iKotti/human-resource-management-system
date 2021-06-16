import "./App.css";
import "semantic-ui-css/semantic.min.css";
import Navbar from "./layout/Navbar";
import HomeDashboard from "./layout/HomeDashboard";
import Footer from "./layout/Footer";

function App() {
  return (
    <div className="App">

      <Navbar/>
      <HomeDashboard/>
      <Footer/>
    </div>
  );
}

export default App;
