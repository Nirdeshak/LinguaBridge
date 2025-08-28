// // import React, { useState } from "react";

// // export default function RegisterPage() {

// //   // const navigate = useNavigate();

// //   const handleStart = () => {
// //     navigate("/HomePage");
// //   };


// //   const [isLogin, setIsLogin] = useState(true);
// //   const [form, setForm] = useState({
// //     name: "",
// //     email: "",
// //     mobile: "",
// //     password: "",
// //   });

// //   const handleChange = (e) =>
// //     setForm({ ...form, [e.target.name]: e.target.value });

// //   const handleSubmit = (e) => {
// //     e.preventDefault();
// //     if (isLogin) {
// //       alert("Logged in successfully");
// //     } else {
// //       alert("Registered successfully");
// //     }
// //   };

// //   return (
// //     <div className="min-h-screen bg-gradient-to-b from-pink-50 to-white flex items-center justify-center px-4">
// //       <div className="bg-white rounded-xl shadow-md w-full max-w-sm p-6">
// //         {/* Logo */}
// //         <h1 className="text-3xl font-bold text-center text-gray-800 mb-6">
// //           English App
// //         </h1>

// //         {/* Form */}
// //         <form onSubmit={handleSubmit} className="space-y-4">
// //           {!isLogin && (
// //             <input
// //               type="text"
// //               name="name"
// //               placeholder="Full Name"
// //               value={form.name}
// //               onChange={handleChange}
// //               className="input"
// //               required
// //             />
// //           )}
// //           <input
// //             type="text"
// //             name="mobile"
// //             placeholder="Mobile number or email"
// //             value={form.mobile}
// //             onChange={handleChange}
// //             className="input"
// //             required
// //           />
// //           {!isLogin && (
// //             <input
// //               type="email"
// //               name="email"
// //               placeholder="Email address"
// //               value={form.email}
// //               onChange={handleChange}
// //               className="input"
// //               required
// //             />
// //           )}
// //           <input
// //             type="password"
// //             name="password"
// //             placeholder="Password"
// //             value={form.password}
// //             onChange={handleChange}
// //             className="input"
// //             required
// //           />

// //           <button
// //             type="submit"
// //             className="w-full bg-pink-500 hover:bg-pink-600 text-white font-semibold py-2 rounded transition duration-200"
// //           >
// //             {isLogin ? "Log In" : "Sign Up"}
// //           </button>
// //         </form>

// //         {/* Divider */}
// //         <div className="flex items-center justify-center my-4">
// //           <span className="text-sm text-gray-500">OR</span>
// //         </div>

// //         {/* Google Button (placeholder) */}
// //         <button
// //           className="w-full py-2 border rounded hover:bg-gray-100 text-sm font-medium"
// //           onClick={() => alert("Google Login Coming Soon")}
// //         >
// //           Continue with Google
// //         </button>

// //         {/* Toggle */}
// //         <p className="text-sm text-center mt-6 text-gray-600">
// //           {isLogin ? "Don't have an account?" : "Already have an account?"}{" "}
// //           <button
// //             onClick={() => setIsLogin(!isLogin)}
// //             className="text-pink-500 font-medium hover:underline"
// //           >
// //             {isLogin ? "Sign up" : "Log in"}
// //           </button>
// //         </p>
// //       </div>

// //        <div className="flex flex-col items-center gap-4">
// //               <button
// //                 onClick={handleStart}
// //                 className="relative w-20 h-20 rounded-full bg-orange-500 flex items-center justify-center shadow-lg"
// //               >
// //                 <FaStar className="text-white text-2xl" />
// //                 <span className="absolute -bottom-6 text-sm bg-gray-900 px-2 py-1 rounded">
// //                   start
// //                 </span>
// //               </button>
// //               </div>
// //     </div>
// //   );
// // }



// // src/UsersPage.jsx
// import React, { useEffect, useState } from "react";
// import axios from "axios";

// export default function RegisterPage() {
//   const [users, setUsers] = useState([]);
//   const [form, setForm] = useState({ id: "", name: "", email: "" });
//   const [editing, setEditing] = useState(false);


//   // ✅ Add user
//   const addUser = async () => {
//     try {
//       await axios.post("http://localhost:8080/api/users/InsertUsers", {
//         name: form.name,
//         email: form.email,
//       });
//       setForm({ id: "", name: "", email: "" });
//       fetchUsers();
//     } catch (err) {
//       console.error("Error adding user:", err);
//     }
//   };

//   // ✅ Update user
//   const updateUser = async () => {
//     try {
//       await axios.put(`http://localhost:8080/api/users/UpdateUsers/${form.id}`, {
//         name: form.name,
//         email: form.email,
//       });
//       setForm({ id: "", name: "", email: "" });
//       setEditing(false);
//       fetchUsers();
//     } catch (err) {
//       console.error("Error updating user:", err);
//     }
//   };

//   // ✅ Edit button click
//   const editUser = (user) => {
//     setForm(user);
//     setEditing(true);
//   };

//   return (
//     <div className="min-h-screen bg-gray-100 flex flex-col items-center py-10">
//       <h1 className="text-3xl font-bold mb-6">Users Management</h1>

//       {/* Form */}
//       <div className="bg-white shadow-lg rounded-2xl p-6 w-96 mb-8">
//         <input
//           type="text"
//           name="name"
//           placeholder="Name"
//           value={form.name}
//           onChange={handleChange}
//           className="w-full mb-3 p-2 border rounded-lg"
//         />
//         <input
//           type="email"
//           name="email"
//           placeholder="Email"
//           value={form.email}
//           onChange={handleChange}
//           className="w-full mb-3 p-2 border rounded-lg"
//         />

//         {editing ? (
//           <button
//             onClick={updateUser}
//             className="w-full bg-blue-600 text-white p-2 rounded-lg hover:bg-blue-700"
//           >
//             Update User
//           </button>
//         ) : (
//           <button
//             onClick={addUser}
//             className="w-full bg-green-600 text-white p-2 rounded-lg hover:bg-green-700"
//           >
//             Add User
//           </button>
//         )}
//       </div>

//       {/* Users List */}
//       <div className="bg-white shadow-lg rounded-2xl p-6 w-[32rem]">
//         <h2 className="text-xl font-semibold mb-4">All Users</h2>
//         {users.length === 0 ? (
//           <p className="text-gray-500">No users found.</p>
//         ) : (
//           <ul>
//             {users.map((user) => (
//               <li
//                 key={user.id}
//                 className="flex justify-between items-center border-b py-2"
//               >
//                 <span>
//                   <strong>{user.name}</strong> <br />
//                   <span className="text-gray-500">{user.email}</span>
//                 </span>
//                 <button
//                   onClick={() => editUser(user)}
//                   className="bg-yellow-500 text-white px-3 py-1 rounded-lg hover:bg-yellow-600"
//                 >
//                   Edit
//                 </button>
//               </li>
//             ))}
//           </ul>
//         )}
//       </div>
//     </div>
//   );
// }
