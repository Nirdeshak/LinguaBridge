// // src/App.jsx
// import React from "react";
// import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
// import ToBeSentencesQuiz from "./Components/ToBeSentencesQuiz";
// import MainPage from "./Components/MainPage";
// import StartPage from "./Components/StartPage";
// import ToBePastSentences from "./Components/ToBePastSentences";
// import ToBeFutureSentences from "./Components/ToBeFutureSentences";
// import ToBeHaveSentences from "./Components/ToBeHaveSentences";
// import ToBeHavePastSentences from "./Components/ToBeHavePastSentences";
// import ToBeHaveFutureSentences from "./Components/ToBeHaveFutureSentences";
// import ToBeThereisSentences from "./Components/ToBeThereisSentences";
// import ToBeThereisPastSentences from "./Components/ToBeThereisPastSentences";
// import ThereisFutureSentences from "./Components/ThereisFutureSentences";
// import SimplePresentSentences from "./Components/SimplePresentSentences";
// import SimplePastSentences from "./Components/SimplePastSentences";
// import SimpleFutureSentences from "./Components/SimpleFutureSentences";
// import PastContinuousSentences from "./Components/PastContinuousSentences";
// import PresentContinuousSentences from "./Components/PresentContinuousSentences";

// export default function App() {
//   return (
//     <Router>
//       <Routes>
//         <Route path="/" element={<MainPage />} />
//         <Route path="/start" element={<StartPage />} />
//         <Route path="/quiz/:type" element={<ToBeSentencesQuiz />} />
//         <Route path="/ToBePastSentences" element={<ToBePastSentences />} />
//         <Route path="/start" element={<StartPage />} />
//         <Route path="/past/:type" element={<ToBePastSentences />} />
//         <Route path="/future/:type" element={<ToBeFutureSentences />} />

//         <Route path="/have/:type" element={<ToBeHaveSentences />} />

//         <Route path="/have/past/:type" element={<ToBeHavePastSentences />} />

//         <Route
//           path="/have/future/:type"
//           element={<ToBeHaveFutureSentences />}
//         />

//         <Route path="/thereis/:type" element={<ToBeThereisSentences />} />

//         <Route
//           path="/thereis/past/:type"
//           element={<ToBeThereisPastSentences />}
//         />

//        <Route
//           path="/thereis/future/:type"
//           element={<ThereisFutureSentences />}
//         />

//         <Route path="/simplepresent/:type" element={<SimplePresentSentences />} />

//         <Route path="/simplepast/:type" element={<SimplePastSentences />} />

//         <Route path="/simplefuture/:type" element={<SimpleFutureSentences />} />

//         <Route path="/presentcontinuos/:type" element={<PresentContinuousSentences />} />

//         <Route path="/pastcontinuos/:type" element={<PastContinuousSentences />} />
//       </Routes>
//     </Router>
//   );
// }



// src/App.jsx
import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import ToBeSentencesQuiz from "./Components/ToBeSentencesQuiz";
import MainPage from "./Components/MainPage";
import StartPage from "./Components/StartPage";
import ToBePastSentences from "./Components/ToBePastSentences";
import ToBeFutureSentences from "./Components/ToBeFutureSentences";
import ToBeHaveSentences from "./Components/ToBeHaveSentences";
import ToBeHavePastSentences from "./Components/ToBeHavePastSentences";
import ToBeHaveFutureSentences from "./Components/ToBeHaveFutureSentences";
import ToBeThereisSentences from "./Components/ToBeThereisSentences";
import ToBeThereisPastSentences from "./Components/ToBeThereisPastSentences";
import ThereisFutureSentences from "./Components/ThereisFutureSentences";
import SimplePresentSentences from "./Components/SimplePresentSentences";
import SimplePastSentences from "./Components/SimplePastSentences";
import SimpleFutureSentences from "./Components/SimpleFutureSentences";
import PastContinuousSentences from "./Components/PastContinuousSentences";
import PresentContinuousSentences from "./Components/PresentContinuousSentences";
// import RegisterPage from "./Components/RegisterPage";

export default function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<MainPage />} />
        <Route path="/start" element={<StartPage />} />
        {/* <Route path="/RegisterPage" element={<RegisterPage />} /> */}

        {/* To Be Sentences */}
        <Route path="/quiz/:type" element={<ToBeSentencesQuiz />} />
        <Route path="/past/:type" element={<ToBePastSentences />} />
        <Route path="/future/:type" element={<ToBeFutureSentences />} />

        {/* Have Sentences */}
        <Route path="/have/:type" element={<ToBeHaveSentences />} />
        <Route path="/have/past/:type" element={<ToBeHavePastSentences />} />
        <Route path="/have/future/:type" element={<ToBeHaveFutureSentences />} />

        {/* There is/There are Sentences */}
        <Route path="/thereis/:type" element={<ToBeThereisSentences />} />
        <Route path="/thereis/past/:type" element={<ToBeThereisPastSentences />} />
        <Route path="/thereis/future/:type" element={<ThereisFutureSentences />} />

        {/* Simple Tenses */}
        <Route path="/simplepresent/:type" element={<SimplePresentSentences />} />
        <Route path="/simplepast/:type" element={<SimplePastSentences />} />
        <Route path="/simplefuture/:type" element={<SimpleFutureSentences />} />

        {/* Continuous Tenses */}
        <Route path="/presentcontinuous/:type" element={<PresentContinuousSentences />} />
        <Route path="/pastcontinuous/:type" element={<PastContinuousSentences />} />
      </Routes>
    </Router>
  );
}






// import React from "react";
// import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
// import MainPage from "./Components/MainPage";
// import StartPage from "./Components/StartPage";
// import ToBeSentencesQuiz from "./Components/ToBeSentencesQuiz";
// import ToBePastSentences from "./Components/ToBePastSentences";
// import ToBeFutureSentences from "./Components/ToBeFutureSentences";
// import ToBeHaveSentences from "./Components/ToBeHaveSentences";
// import ToBeHavePastSentences from "./Components/ToBeHavePastSentences";
// import ToBeHaveFutureSentences from "./Components/ToBeHaveFutureSentences";
// import ToBeThereisSentences from "./Components/ToBeThereisSentences";
// import ToBeThereisPastSentences from "./Components/ToBeThereisPastSentences";
// import MainPage from "./Components/MainPage";

// export default function App() {
//   return (
//     <Router>
//       <Routes>

//         <Route path="/" element={<MainPage />} />

//         {/* Home / Start Screen */}
//         <Route path="/" element={<StartPage />} />

//         {/* ✅ Present quizzes */}
//         <Route path="/quiz/:type" element={<ToBeSentencesQuiz />} />

//         {/* ✅ Past quizzes */}
//         <Route path="/past/:type" element={<ToBePastSentences />} />

//         {/* ✅ Future quizzes */}
//         <Route path="/future/:type" element={<ToBeFutureSentences />} />

//         <Route path="/have/:type" element={<ToBeHaveSentences />} />

//         <Route path="/have/past/:type" element={<ToBeHavePastSentences />} />

//         <Route path="/have/future/:type" element={<ToBeHaveFutureSentences />} />

//         <Route path="/thereis/:type" element={<ToBeThereisSentences />} />

//         <Route path="/thereis/past/:type" element={<ToBeThereisPastSentences />} />
//       </Routes>
//     </Router>
//   );
// }
