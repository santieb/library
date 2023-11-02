

<template>
  <header class="flex items-center w-full bg-white dark:bg-dark">
    <div class="container mx-auto">
      <div class="relative flex items-center justify-between -mx-4">
        <img class="w-20 h-20"
          src="https://thumbs.dreamstime.com/b/beautiful-meticulously-designed-library-icon-perfect-use-designing-developing-websites-printed-materials-presentations-112019830.jpg"
          alt="Librería">
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
                  <a href="javascript:void(0)"
                    class="flex py-2 text-base font-medium text-body-color hover:text-dark lg:ml-12 lg:inline-flex dark:text-dark-6 dark:hover:text-white">
                    Home
                  </a>
                </li>
              </ul>
            </nav>
          </div>
          <div class="justify-end hidden pr-16 sm:flex lg:pr-0">
            <a href="javascript:void(0)"
              class="py-3 text-base font-medium px-7 text-dark dark:text-white hover:text-primary">
              Login
            </a>
            <a href="javascript:void(0)"
              class="py-3 text-base font-medium text-white rounded-md bg-primary px-7 hover:bg-primary/90">
              Sign Up
            </a>
          </div>
        </div>
      </div>
    </div>
  </header>
</template>
