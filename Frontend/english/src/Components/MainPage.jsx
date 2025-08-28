import React from "react";
import { useNavigate } from "react-router-dom";

const MainPage = () => {
  const navigate = useNavigate();

  const handleGetStarted = () => {
    navigate("/start"); 
  };

  return (
    <div className="min-h-screen flex flex-col justify-between items-center bg-gradient-to-b from-blue-300 to-blue-100 px-4 pt-safe pb-safe">
      <div className="mt-20 w-full text-center max-w-md mx-auto">
        <h1 className="text-3xl sm:text-4xl font-extrabold text-blue-900 leading-tight">
          Welcome to <br /> English App
        </h1>
        <p className="mt-3 text-base sm:text-lg text-blue-700">
          Learn & Translate Daily
        </p>
      </div>

      <div className="w-full max-w-md px-2 mb-10 space-y-4">
        <button
          onClick={handleGetStarted}
          className="w-full bg-blue-600 text-white py-4 rounded-2xl text-lg font-bold shadow-lg active:scale-95 transition"
        >
          🚀 Get Started
        </button>
      </div>
    </div>
  );
};

export default MainPage;
