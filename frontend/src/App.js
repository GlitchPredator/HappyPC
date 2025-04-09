import './App.css';
import 'animate.css'
import { useState } from 'react';
import Button from 'react-bootstrap/Button';


function App() {
  const [introVisible, setIntroVisible] = useState(true);
  const [budgetQuestion, setBudgetQuestion] = useState(false);
  const [categoryQuestion, setCategoryQuestion] = useState(false);
  const [storageQuestion, setStorageQuestion] = useState(false);
  const [brandQuestion, setBrandQuestion] = useState(false);
  const [capacityQuestion, setCapacityQuestion] = useState(false);
  const [resultModal, showResultModal] = useState(false);

  let answers = [];

  function HideAll() {
    setIntroVisible(false);
    setBudgetQuestion(true);
    
  }

  function HideBudgetQuestion() {
    setBudgetQuestion(false);
    setCategoryQuestion(true);
  }

  function HideCategoryQuestion(categoryType) {
    setCategoryQuestion(false);
    
    if (categoryType === 'office')
      setStorageQuestion(true);
    if (categoryType === 'gaming')
      setBrandQuestion(true);
    if (categoryType === 'editing')
      setCapacityQuestion(true);

    answers.push(categoryType);
  }

  function ShowResultModal() {
    setStorageQuestion(false);
    setBrandQuestion(false);
    setCapacityQuestion(false);

    showResultModal(true);
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
          ) :
            budgetQuestion ? (
              <>
                <p className="h6 mr-3 animate__animated animate__bounceIn"> ℹ️ În regulă, pentru început spune-mi te rog de ce buget dispui. </p>
                <center className='mt-3'>
                  <Button variant='success' className='mb-3' onClick={HideBudgetQuestion}> Mai mult de 5000 de LEI 💵</Button>
                  <Button variant='danger' onClick={HideBudgetQuestion}> Mai puțin de 5000 de LEI (inclusiv) 💵</Button>
                </center>
              </>
            ) :
              categoryQuestion ? (
                <>
                  <p className="h6 mr-3 animate__animated animate__bounceIn">ℹ️ Ce categorie de calculator ți se potrivește? </p>
                  <center className='mt-3 p-6'>
                    <Button variant="success" className='me-3' onClick={() => HideCategoryQuestion('office')}>Office 🧑‍💼</Button>
                    <Button variant="danger" className='me-3' onClick={() => HideCategoryQuestion('gaming')}>Gaming 🎮</Button>
                    <Button variant="warning" onClick={() => HideCategoryQuestion('editing')}>Editing ✏️</Button>
                  </center>
                </>
              ) :
                storageQuestion ? (
                  <>
                    <p className="h6 mr-3 animate__animated animate__bounceIn">ℹ️ Ce tip de storage vrei să aibă? </p>
                    <center className='mt-3 p-6'>
                      <Button variant='success' className="mb-3" onClick={ShowResultModal}>HDD (Hard Disk Drive)</Button>
                      <Button variant='danger' onClick={ShowResultModal}>SSD (Solid State Drive</Button>
                    </center>
                  </>
                ) :
                  brandQuestion ? (
                    <>
                      <p className="h6 mr-3 animate__animated animate__bounceIn">ℹ️ Alege unul dintre brand-urile de mai jos:</p>
                      <center className='mt-3 p-6'>
                        <Button variant='success' className="me-3"onClick={ShowResultModal}>Asus</Button>
                        <Button variant='danger' className="me-3" onClick={ShowResultModal}>Myria</Button>
                        <Button variant='warning' onClick={ShowResultModal}>Lenovo</Button>
                      </center>
                    </>
                  ) :
                    capacityQuestion ? (
                      <>
                        <p className="h6 mr-3 animate__animated animate__bounceIn">ℹ️ Ce capacitate de memorie îți dorești să aibă?</p>
                        <center className='mt-3 p-6'>
                          <Button variant='success' className="mb-3" onClick={ShowResultModal}> Mai mic decât UN_NUMAR</Button>
                          <Button variant='danger' onClick={ShowResultModal} >Mai mare sau egal decât ALT_NUMAR</Button>
                        </center>
                      </>
                    ) :
                      resultModal ? (
                      <>
                        <p>PC_REZULTAT</p>
                      </>
                      )
                      : 
                      <>
                        <p>S-a produs o eroare în timpul căutărilor, te rugăm încearcă mai târziu.</p>
                      </>
          }
        </div>
      </center>
    </div >
  );
}

export default App;
