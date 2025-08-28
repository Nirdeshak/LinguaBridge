
import React, { useEffect, useState } from "react";
import axios from "axios";
import { useParams, useNavigate, useLocation } from "react-router-dom"; // ✅ useLocation added
import { IoCheckmarkCircle, IoCloseCircle } from "react-icons/io5";

export default function ToBeFutureSentences() {
  const [sentences, setSentences] = useState([]);
  const [loading, setLoading] = useState(false);
  const [selectedWords, setSelectedWords] = useState([]);
  const [showResult, setShowResult] = useState(false);
  const [isCorrect, setIsCorrect] = useState(false);
  const [score, setScore] = useState(0);
  const [quizCompleted, setQuizCompleted] = useState(false);
  const [currentIndex, setCurrentIndex] = useState(0);

  const { type } = useParams();
  const navigate = useNavigate();
  const location = useLocation(); // ✅ properly imported

  const API_BASE = "http://localhost:8080/api/tobe/future";

  const fetchSentences = async () => {
    setLoading(true);
    try {
      const url =
        type === "all" ? `${API_BASE}/all` : `${API_BASE}/type/${type}`;
      const res = await axios.get(url);

      const fixedData = res.data.map((q) => {
        let optionsArray = [];
        if (Array.isArray(q.options)) {
          optionsArray = q.options;
        } else if (typeof q.options === "string") {
          try {
            optionsArray = JSON.parse(q.options);
          } catch {
            const cleaned = q.options
              .replace(/^\[|\]$/g, "")
              .replace(/"/g, "")
              .trim();
            optionsArray = cleaned
              ? cleaned.split(",").map((o) => o.trim())
              : [];
          }
        }
        const answerWords = q.correctAnswer.split(" ");
        answerWords.forEach((w) => {
          if (w.includes("?") && !optionsArray.includes(w)) {
            optionsArray.push(w);
          }
        });
        return { ...q, options: optionsArray };
      });

      setSentences(fixedData);
      setCurrentIndex(0);
      setSelectedWords([]);
      setShowResult(false);
      setIsCorrect(false);
      setScore(0);
      setQuizCompleted(false);
    } catch (e) {
      console.error("Error fetching sentences:", e);
    }
    setLoading(false);
  };

  useEffect(() => {
    fetchSentences();
  }, [type]);

  const handleWordClick = (word) => {
    setSelectedWords((prev) =>
      prev.includes(word) ? prev.filter((w) => w !== word) : [...prev, word]
    );
  };

  const handleCheck = () => {
    let userAnswer = selectedWords.join(" ").trim();
    if (!userAnswer.endsWith(".")) userAnswer += ".";

    let correctAnswer = sentences[currentIndex].correctAnswer.trim();
    if (!correctAnswer.endsWith(".")) correctAnswer += ".";

    const correct = userAnswer === correctAnswer;
    setIsCorrect(correct);
    setShowResult(true);
    if (correct) setScore((p) => p + 1);
  };

  const handleNext = () => {
    if (currentIndex < sentences.length - 1) {
      setSelectedWords([]);
      setShowResult(false);
      setIsCorrect(false);
      setCurrentIndex((p) => p + 1);
    } else {
      setQuizCompleted(true);
    }
  };

  const goBackWithScore = () => {
    navigate("/start", {
      state: {
        score,
        total: sentences.length,
        completedType: type,
        category: location.state?.category || "There Is/Are Future Sentences",
      },
    });
  };

  if (loading)
    return <div className="text-gray-400 text-center p-6">Loading...</div>;
  if (!sentences.length)
    return (
      <div className="text-gray-400 text-center p-6">
        No questions available.
      </div>
    );

  if (quizCompleted) {
    return (
      <div className="bg-gray-900 min-h-screen flex flex-col items-center justify-center text-white px-4">
        <div className="bg-gray-800 p-6 rounded-lg shadow-lg w-full max-w-md text-center">
          <h2 className="text-2xl font-bold mb-4">🎉Quiz complete!</h2>
          <p className="text-lg mb-4">
            Your Score:{" "}
            <span className="text-green-400 font-bold">
              {score} / {sentences.length}
            </span>
          </p>
          <button
            onClick={goBackWithScore}
            className="w-full bg-blue-600 hover:bg-blue-700 py-2 rounded text-white font-semibold"
          >
            ⬅ Return to the start page.
          </button>
        </div>
      </div>
    );
  }

  const currentSentence = sentences[currentIndex];

  return (
    <div className="bg-gray-900 min-h-screen flex flex-col items-center justify-start text-white px-3 py-6">
      <div className="bg-gray-800 p-5 rounded-lg shadow-lg w-full max-w-md">
        <h2 className="text-xl font-bold mb-1 text-center">
          {type === "all" ? "All Questions" : `${type} Question`}
        </h2>
        <p className="text-sm text-gray-300 mb-4 text-center">
          Question {currentIndex + 1} / {sentences.length}
        </p>

        <div className="flex items-center bg-gray-700 p-3 rounded mb-4">
          <span className="text-blue-400 text-lg mr-2">🔊</span>
          <span className="text-white text-base">{currentSentence.question}</span>
        </div>

        <div className="min-h-[48px] border border-dashed border-gray-500 rounded p-2 mb-4 flex flex-wrap gap-2 bg-gray-900">
          {selectedWords.length > 0 ? (
            selectedWords.map((word, i) => (
              <button
                key={`${word}-${i}`}
                onClick={() => handleWordClick(word)}
                className="py-1 px-2 bg-green-700 text-white rounded hover:bg-green-800 text-sm"
              >
                {word}
              </button>
            ))
          ) : (
            <span className="text-gray-500 text-sm">Choose The Word...</span>
          )}
        </div>

        <div className="grid grid-cols-2 sm:grid-cols-3 gap-2 mb-4">
          {currentSentence.options.map((word, i) => (
            <button
              key={`${word}-${i}`}
              onClick={() => handleWordClick(word)}
              className={`py-2 px-3 rounded-md text-sm w-full ${
                selectedWords.includes(word)
                  ? "bg-green-400 text-black font-semibold"
                  : "bg-gray-600 hover:bg-gray-500"
              }`}
            >
              {word}
            </button>
          ))}
        </div>

        {!showResult ? (
          <button
            onClick={handleCheck}
            className="w-full bg-blue-600 hover:bg-blue-700 py-2 rounded text-white font-semibold"
          >
            Check
          </button>
        ) : (
          <div className="mt-4 p-3 rounded bg-gray-700 text-center">
            <p
              className={`text-lg font-bold mb-2 ${
                isCorrect ? "text-green-400" : "text-red-400"
              }`}
            >
              {isCorrect ? (
                <span className="flex justify-center items-center">
                  <IoCheckmarkCircle size={24} className="mr-2 text-green-400" />
                  Correct Answer
                </span>
              ) : (
                <span className="flex justify-center items-center">
                  <IoCloseCircle size={24} className="mr-2 text-red-400" />
                  Wrong Answer
                </span>
              )}
            </p>
            {!isCorrect && (
              <p className="text-red-300 text-sm mb-3">
                <span className="font-bold">Correct Answer:</span> <br />
                {currentSentence.correctAnswer.endsWith(".")
                  ? currentSentence.correctAnswer
                  : currentSentence.correctAnswer + "."}
              </p>
            )}
            <button
              onClick={handleNext}
              className={`w-full mt-2 ${
                isCorrect
                  ? "bg-green-500 hover:bg-green-600"
                  : "bg-red-500 hover:bg-red-600"
              } py-2 rounded text-white font-semibold`}
            >
              {currentIndex === sentences.length - 1
                ? "Complete The Quiz"
                : "Next Question"}
            </button>
          </div>
        )}
      </div>

      <button
        onClick={() => navigate("/start")}
        className="mt-6 text-blue-400 hover:underline"
      >
        ⬅ Go Back
      </button>
    </div>
  );
}

