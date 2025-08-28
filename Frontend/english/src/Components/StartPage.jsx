
// import React, { useEffect, useState } from "react";
// import { useNavigate, useLocation } from "react-router-dom";
// import { IoCheckmarkCircle } from "react-icons/io5";

// export default function StartPage() {
//   const navigate = useNavigate();
//   const location = useLocation();

//   // ✅ Categories with sentence types
//   const CATEGORIES = {
//     "To Be Sentences Quiz": ["Positive", "Negative", "Verbal", "Wh"],
//     "To Be Past Sentences": ["Positive", "Negative", "Verbal", "Wh"],
//     "To Be Future Sentences": ["Positive", "Negative", "Verbal", "Wh"],
//     "Have/Has Sentences": ["Positive", "Negative", "Verbal", "Wh"],
//     "Have/Has Past Sentences": ["Positive", "Negative", "Verbal", "Wh"],
//     "Have/Has Future Sentences": ["Positive", "Negative", "Verbal", "Wh"],
//     "There Is/Are Sentences": ["Positive", "Negative", "Verbal", "Wh"],
//     "There Is/Are Past Sentences": ["Positive", "Negative", "Verbal", "Wh"],
//     "There Is/Are Future Sentences": ["Positive", "Negative", "Verbal", "Wh"],
//     "Simple Present Sentences": ["Positive", "Negative", "Verbal", "Wh"],
//     "Simple Past Sentences": ["Positive", "Negative", "Verbal", "Wh"],
//     "Simple Future Sentences": ["Positive", "Negative", "Verbal", "Wh"],
//     "Present continuous Sentences": ["Positive", "Negative", "Verbal", "Wh"],
//     "Past Continuous Sentences": ["Positive", "Negative", "Verbal", "Wh"],
//   };

//   // ✅ Labels for buttons
//   const CATEGORY_LABELS = {};
//   Object.keys(CATEGORIES).forEach((cat) => {
//     CATEGORY_LABELS[cat] = ["Positive", "Negative", "Verbal", "WH Question"];
//   });

//   const [completedData, setCompletedData] = useState({});

//   // Load completed data from localStorage
//   useEffect(() => {
//     const saved = JSON.parse(localStorage.getItem("completedData")) || {};
//     setCompletedData(saved);
//   }, []);

//   // Update completed data when coming back from quiz
//   useEffect(() => {
//     const scoreData = location.state;
//     if (scoreData?.completedType && scoreData?.category) {
//       setCompletedData((prev) => {
//         const prevCategory = prev[scoreData.category] || [];
//         if (!prevCategory.includes(scoreData.completedType)) {
//           const updatedCategory = [...prevCategory, scoreData.completedType];
//           const updatedData = {
//             ...prev,
//             [scoreData.category]: updatedCategory,
//           };
//           localStorage.setItem("completedData", JSON.stringify(updatedData));
//           return updatedData;
//         }
//         return prev;
//       });
//     }
//   }, [location.state]);

//   // ✅ Quiz button component
//   const QuizButton = ({ category, type, label, index }) => {
//     const completedList = completedData[category] || [];
//     const isCompleted = completedList.includes(type);
//     const isUnlocked =
//       index === 0 || completedList.includes(CATEGORIES[category][index - 1]);

//     // ✅ Route handling (clean & consistent)
//     const path =
//       category === "To Be Past Sentences"
//         ? `/past/${type}`
//         : category === "To Be Future Sentences"
//         ? `/future/${type}`
//         : category === "Have/Has Sentences"
//         ? `/have/${type}`
//         : category === "Have/Has Past Sentences"
//         ? `/have/past/${type}`
//         : category === "Have/Has Future Sentences"
//         ? `/have/future/${type}`
//         : category === "There Is/Are Sentences"
//         ? `/thereis/${type}`
//         : category === "There Is/Are Past Sentences"
//         ? `/thereis/past/${type}`
//         : category === "There Is/Are Future Sentences"
//         ? `/thereis/future/${type}`
//         : category === "Simple Present Sentences"
//         ? `/simplepresent/${type}`
//         : category === "Simple Past Sentences"
//         ? `/simplepast/${type}`
//         : category === "Simple Future Sentences"
//         ? `/simplefuture/${type}`
//         : category === "Present continuous Sentences"
//         ? `/presentcontinuous/${type}`
//         : category === "Past Continuous Sentences"
//         ? `/pastcontinuous/${type}`
//         : `/quiz/${type}`;

//     return (
//       <button
//         onClick={() => isUnlocked && navigate(path, { state: { category } })}
//         disabled={!isUnlocked}
//         className={`w-full py-4 rounded-full flex items-center px-4 gap-3
//           ${
//             isCompleted
//               ? "bg-green-700"
//               : isUnlocked
//               ? "bg-blue-500"
//               : "bg-gray-600 opacity-50"
//           }
//         `}
//       >
//         {isCompleted && (
//           <IoCheckmarkCircle className="text-white mr-2" size={24} />
//         )}
//         <span>{label}</span>
//       </button>
//     );
//   };

//   return (
//     <div className="bg-gray-900 text-white min-h-screen flex flex-col items-center px-4 pt-10 gap-8">
//       <h1 className="text-3xl font-bold">Quiz Categories</h1>

//       {/* ✅ Detailed Categories with progress */}
//       <div className="flex flex-col w-full max-w-md gap-8 mt-6">
//         {Object.keys(CATEGORIES).map((category) => (
//           <div key={category}>
//             <h2 className="text-xl font-semibold mb-3">{category}</h2>
//             <div className="flex flex-col gap-4">
//               {CATEGORIES[category].map((type, idx) => (
//                 <QuizButton
//                   key={`${category}-${type}`}
//                   category={category}
//                   type={type}
//                   label={CATEGORY_LABELS[category][idx]}
//                   index={idx}
//                 />
//               ))}
//             </div>
//           </div>
//         ))}
//       </div>
//     </div>
//   );
// }














import React, { useEffect, useState } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import { IoCheckmarkCircle } from "react-icons/io5";

export default function StartPage() {
  const navigate = useNavigate();
  const location = useLocation();

  // ✅ Categories with sentence types
  const CATEGORIES = {
    "To Be Sentences Quiz": ["Positive", "Negative", "Verbal", "Wh"],
    "To Be Past Sentences": ["Positive", "Negative", "Verbal", "Wh"],
    "To Be Future Sentences": ["Positive", "Negative", "Verbal", "Wh"],
    "Have/Has Sentences": ["Positive", "Negative", "Verbal", "Wh"],
    "Have/Has Past Sentences": ["Positive", "Negative", "Verbal", "Wh"],
    "Have/Has Future Sentences": ["Positive", "Negative", "Verbal", "Wh"],
    "There Is/Are Sentences": ["Positive", "Negative", "Verbal", "Wh"],
    "There Is/Are Past Sentences": ["Positive", "Negative", "Verbal", "Wh"],
    "There Is/Are Future Sentences": ["Positive", "Negative", "Verbal", "Wh"],
    "Simple Present Sentences": ["Positive", "Negative", "Verbal", "Wh"],
    "Simple Past Sentences": ["Positive", "Negative", "Verbal", "Wh"],
    "Simple Future Sentences": ["Positive", "Negative", "Verbal", "Wh"],
    "Present continuous Sentences": ["Positive", "Negative", "Verbal", "Wh"],
    "Past Continuous Sentences": ["Positive", "Negative", "Verbal", "Wh"],
  };

  // ✅ Labels for buttons
  const CATEGORY_LABELS = {};
  Object.keys(CATEGORIES).forEach((cat) => {
    CATEGORY_LABELS[cat] = ["Positive", "Negative", "Verbal", "WH Question"];
  });

  // const [completedData, setCompletedData] = useState({});

  // Load completed data from localStorage
  const [completedData, setCompletedData] = useState(() => {
    const stored = localStorage.getItem("completedData");
    return stored ? JSON.parse(stored) : {};
  });

  // Update completed data when coming back from quiz

  // ✅ Update completedData when returning from quiz
  useEffect(() => {
    const scoreData = location.state;
    if (scoreData?.completedType && scoreData?.category) {
      const normalizedType =
        scoreData.completedType.toLowerCase() === "wh question" ||
        scoreData.completedType.toLowerCase() === "wh"
          ? "Wh"
          : scoreData.completedType;

      setCompletedData((prev) => {
        const prevCategory = prev[scoreData.category] || [];
        if (!prevCategory.includes(normalizedType)) {
          const updatedCategory = [...prevCategory, normalizedType];
          const updatedData = { ...prev, [scoreData.category]: updatedCategory };
          localStorage.setItem("completedData", JSON.stringify(updatedData));
          return updatedData;
        }
        return prev;
      });
    }
  }, [location.state]);

  // ✅ Quiz button component
  const QuizButton = ({ category, type, index }) => {
    const completedList = completedData[category] || [];
    const isCompleted = completedList.includes(type);
    const isUnlocked =
      index === 0 || completedList.includes(CATEGORIES[category][index - 1]);


    // ✅ Route handling (clean & consistent)
    const path =
      category === "To Be Past Sentences"
        ? `/past/${type}`
        : category === "To Be Future Sentences"
        ? `/future/${type}`
        : category === "Have/Has Sentences"
        ? `/have/${type}`
        : category === "Have/Has Past Sentences"
        ? `/have/past/${type}`
        : category === "Have/Has Future Sentences"
        ? `/have/future/${type}`
        : category === "There Is/Are Sentences"
        ? `/thereis/${type}`
        : category === "There Is/Are Past Sentences"
        ? `/thereis/past/${type}`
        : category === "There Is/Are Future Sentences"
        ? `/thereis/future/${type}`
        : category === "Simple Present Sentences"
        ? `/simplepresent/${type}`
        : category === "Simple Past Sentences"
        ? `/simplepast/${type}`
        : category === "Simple Future Sentences"
        ? `/simplefuture/${type}`
        : category === "Present continuous Sentences"
        ? `/presentcontinuous/${type}`
        : category === "Past Continuous Sentences"
        ? `/pastcontinuous/${type}`
        : `/quiz/${type}`;

    return (
      <button
        onClick={() => isUnlocked && navigate(path, { state: { category } })}
        disabled={!isUnlocked}
        className={`w-full py-4 rounded-full flex items-center px-4 gap-3
          ${
            isCompleted
              ? "bg-green-700"
              : isUnlocked
              ? "bg-blue-500"
              : "bg-gray-600 opacity-50"
          }
        `}
      >
        {isCompleted && <IoCheckmarkCircle className="text-white" size={20} />}
        <span>{type}</span>
      </button>
    );
  };

  return (
    <div className="bg-gray-900 text-white min-h-screen flex flex-col items-center px-4 pt-10 gap-8">
      <h1 className="text-3xl font-bold">Quiz Categories</h1>

      {/* ✅ Detailed Categories with progress */}
      <div className="flex flex-col text-2xl px-5 w-full max-w-md gap-8 mt-6">
        {Object.keys(CATEGORIES).map((category) => (
          <div key={category}>
            <h2 className="text-xl font-semibold mb-3">{category}</h2>
            <div className="flex flex-col gap-4 ">
              {CATEGORIES[category].map((type, idx) => (
                <QuizButton
                  key={`${category}-${type}`}
                  category={category}
                  type={type}
                  label={CATEGORY_LABELS[category][idx]}
                  index={idx}
                />
              ))}
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}
