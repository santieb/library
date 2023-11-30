<template>
  <header class="flex items-center w-full bg-slate-200 shadow-lg mb-20 dark:bg-dark">
    <div class="container mx-auto">
      <div class="relative flex items-center justify-between -mx-4">
        <router-link to="/">
          <img class="w-20 h-20"
            src="https://thumbs.dreamstime.com/b/beautiful-meticulously-designed-library-icon-perfect-use-designing-developing-websites-printed-materials-presentations-112019830.jpg"
            alt="Librería">
        </router-link>
        <div class="flex items-center justify-between w-full px-4">
          <div>
            <button
              class="absolute right-4 top-1/2 block -translate-y-1/2 rounded-lg px-3 py-[6px] ring-primary focus:ring-2 lg:hidden">
              <span class="relative my-[6px] block h-[2px] w-[30px] bg-body-color dark:bg-white"></span>
              <span class="relative my-[6px] block h-[2px] w-[30px] bg-body-color dark:bg-white"></span>
              <span class="relative my-[6px] block h-[2px] w-[30px] bg-body-color dark:bg-white"></span>
            </button>
            <nav
              class="absolute right-4 top-full w-full max-w-[250px] rounded-lg bg-white py-5 px-6 shadow lg:static lg:block lg:w-full lg:max-w-full lg:shadow-none dark:bg-dark-2 lg:dark:bg-transparent">
              <ul class="block lg:flex">
                <li>
                  <router-link to="/" class="flex py-2 text-base font-medium text-body-color hover:font-bold lg:ml-12 lg:inline-flex dark:text-dark-6 ">
                    Home
                  </router-link>
                </li>
                <li>
                  <router-link to="/books" class="flex py-2 text-base font-medium text-body-color hover:font-bold lg:ml-12 lg:inline-flex dark:text-dark-6 ">
                    Books
                  </router-link>
                </li>
                <li>
                  <router-link to="/book-form" class="flex py-2 text-base font-medium text-body-color hover:font-bold lg:ml-12 lg:inline-flex dark:text-dark-6 ">
                    Book form
                  </router-link>
                </li>
                <li>
                  <router-link to="/register" class="flex py-2 text-base font-medium text-body-color hover:font-bold lg:ml-12 lg:inline-flex dark:text-dark-6 e">
                    Register user
                  </router-link>
                </li>
                <li>
                  <router-link to="/login" class="flex py-2 text-base font-medium text-body-color hover:font-bold lg:ml-12 lg:inline-flex dark:text-dark-6 ">
                    Login
                  </router-link>
                </li>
              </ul>
            </nav>
          </div>
        </div>
      </div>
    </div>
  </header>
</template>