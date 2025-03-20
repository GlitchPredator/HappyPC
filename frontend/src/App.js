import './App.css';
import 'animate.css'
import { useState } from 'react';
import Button from 'react-bootstrap/Button';

function App() {
  const [introVisible, setIntroVisible] = useState(true);

  function HideAll() {
    setIntroVisible(false);
  }

  return (
    <div className="container vh-100 d-flex justify-content-center align-items-center">
      <center>
        <div className="mx-auto p-5 col-6 shadow-lg modalStyle animate__animated animate__fadeIn" style={{ width: "450px" }}>
          <p className="h1 animate__animated animate__zoomIn">HappyPC 🧑‍💻</p>

          {introVisible ? (

            <div className="w-100 text-start">
              <p className="h6 mr-3 animate__animated animate__bounceIn animate__delay-1s">ℹ️ Salutare, eu sunt Happy, asistentul tău virtual! ☺️</p>
              <p className="animate__animated animate__zoomIn animate__delay-2s">Dă-mi voie să te ajut să îți alegi un calculator.  😎</p>
              <center>
                <Button onClick={HideAll} variant="danger" className="mt-3 animate__animated animate__fadeIn animate__delay-3s">Vreau un PC nou</Button>
              </center>
            </div>
          ) : <></>
          }
        </div>
      </center>
    </div >
  );
}

export default App;
