# Deployment Guide for CamLiveBilliard Website

## Quick Start

Your website is ready to deploy! Choose one of the following methods:

## Method 1: GitHub Pages (Recommended - Free & Easy)

1. **Create GitHub Repository**
   ```bash
   cd website
   git init
   git add .
   git commit -m "Initial commit"
   git branch -M main
   git remote add origin https://github.com/yourusername/camlivebilliard-website.git
   git push -u origin main
   ```

2. **Enable GitHub Pages**
   - Go to your repository on GitHub
   - Click Settings > Pages
   - Under "Source", select "main" branch
   - Click Save
   - Your site will be live at: `https://yourusername.github.io/camlivebilliard-website`

3. **Custom Domain (Optional)**
   - Add a CNAME file with your domain
   - Configure DNS settings with your domain provider
   - Add domain in GitHub Pages settings

## Method 2: Netlify (Free with Custom Domain)

1. **Sign Up**
   - Go to [netlify.com](https://netlify.com)
   - Sign up for free account

2. **Deploy**
   - Drag and drop the `website` folder into Netlify
   - Or connect your GitHub repository
   - Site deploys automatically

3. **Custom Domain**
   - Go to Domain Settings
   - Add your custom domain
   - Follow DNS configuration instructions

## Method 3: Firebase Hosting (Free)

1. **Install Firebase CLI**
   ```bash
   npm install -g firebase-tools
   ```

2. **Login and Initialize**
   ```bash
   firebase login
   cd website
   firebase init hosting
   ```

3. **Deploy**
   ```bash
   firebase deploy
   ```

## Method 4: Vercel (Free)

1. **Install Vercel CLI**
   ```bash
   npm install -g vercel
   ```

2. **Deploy**
   ```bash
   cd website
   vercel
   ```

## Method 5: Traditional Web Hosting

1. **Upload Files**
   - Use FTP client (FileZilla, Cyberduck)
   - Or use cPanel File Manager
   - Upload all files from `website` folder to public_html or www directory

2. **Set Permissions**
   - Ensure files are readable (644 for files, 755 for directories)

## After Deployment

### 1. Update URLs

Replace placeholder URLs in your files:

- **index.html**: Update Google Play Store link
- **sitemap.xml**: Replace `www.camlivebilliard.com` with your actual domain
- **robots.txt**: Update sitemap URL

### 2. Test Your Website

Visit these pages and verify everything works:
- Homepage: `https://yourdomain.com/`
- Privacy: `https://yourdomain.com/privacy-policy.html`
- Terms: `https://yourdomain.com/terms-conditions.html`
- Support: `https://yourdomain.com/support.html`

### 3. Google Play Console Setup

1. Go to Google Play Console
2. Select your app
3. Navigate to "Store presence" > "Main store listing"
4. Add your website URL in the "Website" field
5. Add Privacy Policy URL: `https://yourdomain.com/privacy-policy.html`

### 4. SSL Certificate

Ensure your site uses HTTPS:
- GitHub Pages: Automatic
- Netlify: Automatic
- Firebase: Automatic
- Vercel: Automatic
- Traditional hosting: Use Let's Encrypt (free) or your hosting provider's SSL

### 5. SEO Setup

1. **Google Search Console**
   - Add your website
   - Submit sitemap: `https://yourdomain.com/sitemap.xml`

2. **Google Analytics (Optional)**
   - Create account at analytics.google.com
   - Add tracking code before `</head>` in all HTML files

3. **Update Meta Tags**
   - Replace placeholder content in meta descriptions
   - Add Open Graph tags for social sharing

## Troubleshooting

### Site Not Loading
- Check DNS settings (may take 24-48 hours)
- Verify files are in correct directory
- Check file permissions

### Broken Links
- Ensure all files are uploaded
- Check file names match exactly (case-sensitive)
- Verify relative paths are correct

### Mobile Issues
- Test on multiple devices
- Use Chrome DevTools mobile emulator
- Check viewport meta tag is present

## Performance Optimization

### Enable Compression
Add to `.htaccess` (Apache) or server config:
```apache
<IfModule mod_deflate.c>
  AddOutputFilterByType DEFLATE text/html text/css text/javascript application/javascript
</IfModule>
```

### Browser Caching
```apache
<IfModule mod_expires.c>
  ExpiresActive On
  ExpiresByType text/css "access plus 1 year"
  ExpiresByType text/javascript "access plus 1 year"
  ExpiresByType image/svg+xml "access plus 1 year"
</IfModule>
```

## Maintenance

### Regular Updates
- Update "Last Updated" dates in legal pages
- Keep contact information current
- Add new FAQs based on user questions
- Update app features as you add them

### Monitoring
- Check Google Search Console weekly
- Monitor site uptime
- Review user feedback
- Update content based on analytics

## Support

Need help with deployment? Contact: support@camlivebilliard.com

## Checklist

Before going live, verify:

- [ ] All pages load correctly
- [ ] Links work (internal and external)
- [ ] Mobile responsive on all devices
- [ ] Forms work (if any)
- [ ] SSL certificate active (HTTPS)
- [ ] Privacy Policy URL added to Google Play Console
- [ ] Website URL added to Google Play Console
- [ ] Contact emails are correct
- [ ] Google Play Store link works
- [ ] Sitemap submitted to Google
- [ ] Robots.txt accessible
- [ ] No console errors in browser
- [ ] Fast loading times (< 3 seconds)
- [ ] All images load properly
- [ ] Navigation works on mobile
- [ ] Footer links work

## Next Steps

1. Deploy your website using one of the methods above
2. Add the URLs to Google Play Console
3. Test thoroughly on multiple devices
4. Submit your app for review
5. Monitor and update regularly

Good luck with your app launch! 🚀
