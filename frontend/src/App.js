import './App.css';
import 'animate.css'
import { useEffect, useState } from 'react';
import Button from 'react-bootstrap/Button';
import axios from 'axios';

function App() {
  const [introVisible, setIntroVisible] = useState(true);
  const [budgetQuestion, setBudgetQuestion] = useState(false);
  const [categoryQuestion, setCategoryQuestion] = useState(false);
  const [storageQuestion, setStorageQuestion] = useState(false);
  const [brandQuestion, setBrandQuestion] = useState(false);
  const [capacityQuestion, setCapacityQuestion] = useState(false);
  const [resultModal, showResultModal] = useState(false);

  const [name, setName] = useState('');
  const [category, setCategory] = useState('');
  const [ram, setRam] = useState(0);
  const [storage, setStorage] = useState('');
  const [price, setPrice] = useState(0.0);

  const [recomandation, setRecomandation] = useState('');

  function HideAll() {
    setIntroVisible(false);
    setBudgetQuestion(true);
  }

  function HideBudgetQuestion(budget) {
    setBudgetQuestion(false);
    setCategoryQuestion(true);

    if (budget === 'big') {
      setPrice(5100.00);
    } else {
      setPrice(5000.00);
    }
    console.log(budget);
  }

  function HideCategoryQuestion(categoryType) {
    setCategoryQuestion(false);

    if (categoryType === 'office') {
      setStorageQuestion(true);
      setCategory('office');
    }
    if (categoryType === 'gaming') {
      setBrandQuestion(true);
      setCategory('gaming');
    }
    if (categoryType === 'editing') {
      setCapacityQuestion(true);
      setCategory('design');
    }
  }

  function ShowResultModal(fromModal, answer) {
    if (fromModal === 'storageModal') {
      setStorage(answer);
    }
    else if (fromModal === 'brandModal') {
      setName(answer);
    }
    else { // capacityModal
      setRam(answer);
    }

    setStorageQuestion(false);
    setBrandQuestion(false);
    setCapacityQuestion(false);

    showResultModal(true);
  }

  function StartAgain() {
    showResultModal(false);
    setIntroVisible(true);
  }

  useEffect(() => {
    if (resultModal === true) {
      axios.post('http://localhost:8080/api/inference/answers', {
        name: name,
        category: category,
        ram: ram,
        storage: storage,
        price: price
      })
        .then(function (response) {
          console.log(response);
          setRecomandation(response.data);

        })
        .catch(function (error) {
          console.log(error);
        });
    }
  }, [resultModal]);

  console.log('values ', name, category, ram, storage, price);

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
                  <Button variant='success' className='mb-3' onClick={() => HideBudgetQuestion('big')}> Mai mult de 5000 de LEI 💵</Button>
                  <Button variant='danger' onClick={() => HideBudgetQuestion('small')}> Mai puțin de 5000 de LEI (inclusiv) 💵</Button>
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
                      <Button variant='success' className="mb-3" onClick={() => ShowResultModal('storageModal', 'HDD')}>HDD (Hard Disk Drive)</Button>
                      <Button variant='danger' onClick={() => ShowResultModal('storageModal', 'SSD')}>SSD (Solid State Drive</Button>
                    </center>
                  </>
                ) :
                  brandQuestion ? (
                    <>
                      <p className="h6 mr-3 animate__animated animate__bounceIn">ℹ️ Alege unul dintre brand-urile de mai jos:</p>
                      <center className='mt-3 p-6'>
                        <Button variant='success' className="me-3" onClick={() => ShowResultModal('brandModal', 'Asus')}>Asus</Button>
                        <Button variant='danger' className="me-3" onClick={() => ShowResultModal('brandModal', 'Myria')}>Myria</Button>
                        <Button variant='warning' onClick={() => ShowResultModal('brandModal', 'Lenovo')}>Lenovo</Button>
                      </center>
                    </>
                  ) :
                    capacityQuestion ? (
                      <>
                        <p className="h6 mr-3 animate__animated animate__bounceIn">ℹ️ Ce capacitate de memorie îți dorești să aibă?</p>
                        <center className='mt-3 p-6'>
                          <Button variant='success' className="mb-3" onClick={() => ShowResultModal('capacityModal', 15)}> Mai mic decât 16GB</Button>
                          <Button variant='danger' onClick={() => ShowResultModal('capacityModal', 16)} >Mai mare sau egal decât 16GB</Button>
                        </center>
                      </>
                    ) :
                      resultModal ? (
                        <>
                          {
                            <p>{recomandation && (
                              <div>
                                <p>{recomandation.split('Link:')[0]}</p>
                                {
                                  recomandation.includes('Link:') &&
                                  <a
                                    href={recomandation.split('Link:')[1].trim()}
                                    target="_blank"
                                    rel="noopener noreferrer"
                                  >
                                    Click aici pentru mai multe detalii <span className="no-underline-icon">🔗</span>
                                  </a>
                                }
                              <Button variant='primary' className='mt-3 shadow-lg' onClick={StartAgain}>Încearcă din nou 🔄️</Button>
                              </div>
                            )}</p>
                          }
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
